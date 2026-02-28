package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(7));
            serverChannel.configureBlocking(false);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("NIO Echo server started on port " + 7);

            Set<SocketChannel> clients = Collections.synchronizedSet(new HashSet<>());

            Thread consoleThread = new Thread(() -> {
                try (BufferedReader consoleReader =
                             new BufferedReader(new InputStreamReader(System.in))) {
                    String line;
                    while ((line = consoleReader.readLine()) != null) {
                        synchronized (clients) {
                            ByteBuffer buf = ByteBuffer.wrap((line + System.lineSeparator()).getBytes());
                            for (SocketChannel ch : clients) {
                                try {
                                    buf.rewind();
                                    ch.write(buf);
                                } catch (IOException e) {
                                    try {
                                        ch.close();
                                    } catch (IOException ignored) {
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Console thread stopped: " + e.getMessage());
                }
            });
            consoleThread.setDaemon(true);
            consoleThread.start();

            while (true) {
                selector.select();

                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();

                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();

                    try {
                        if (key.isAcceptable()) {

                            ServerSocketChannel srv = (ServerSocketChannel) key.channel();
                            SocketChannel clientChannel = srv.accept();
                            if (clientChannel != null) {
                                clientChannel.configureBlocking(false);

                                ByteBuffer buf = ByteBuffer.allocate(1024);
                                clientChannel.register(selector, SelectionKey.OP_READ, buf);
                                clients.add(clientChannel);
                                System.out.println("Client connected: " + clientChannel.getRemoteAddress());
                            }

                        } else if (key.isReadable()) {

                            SocketChannel clientChannel = (SocketChannel) key.channel();
                            ByteBuffer buf = (ByteBuffer) key.attachment();

                            int bytesRead = clientChannel.read(buf);
                            if (bytesRead == -1) {
                                System.out.println("Client disconnected: " + clientChannel.getRemoteAddress());
                                clients.remove(clientChannel);
                                clientChannel.close();
                                key.cancel();
                                continue;
                            }

                            if (bytesRead > 0) {
                                buf.flip();

                                byte[] data = new byte[buf.remaining()];
                                buf.get(data);
                                buf.clear();

                                String msg = new String(data).trim();
                                if (!msg.isEmpty()) {
                                    System.out.println("Received from client: " + msg);

                                    if (!msg.startsWith("Echo:")) {
                                        String echo = "Echo: " + msg + "\n";
                                        ByteBuffer outBuf = ByteBuffer.wrap(echo.getBytes());
                                        while (outBuf.hasRemaining()) {
                                            clientChannel.write(outBuf);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}