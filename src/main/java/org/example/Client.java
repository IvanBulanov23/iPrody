package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 7;

        try {
            Selector selector = Selector.open();
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress(host, port));

            channel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ, ByteBuffer.allocate(1024));

            System.out.println("Connecting to server " + host + ":" + port + "...");

            Thread consoleThread = new Thread(() -> {
                try (BufferedReader consoleReader =
                             new BufferedReader(new InputStreamReader(System.in))) {
                    String line;
                    while ((line = consoleReader.readLine()) != null) {
                        try {
                            ByteBuffer buf = ByteBuffer.wrap((line + System.lineSeparator()).getBytes());
                            while (buf.hasRemaining()) {
                                channel.write(buf);
                            }
                        } catch (IOException e) {
                            System.out.println("Console send error: " + e.getMessage());
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Console thread error: " + e.getMessage());
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
                        if (key.isConnectable()) {
                            SocketChannel sc = (SocketChannel) key.channel();
                            if (sc.finishConnect()) {
                                System.out.println("Connected to server.");
                            }

                        } else if (key.isReadable()) {
                            SocketChannel sc = (SocketChannel) key.channel();
                            ByteBuffer buf = (ByteBuffer) key.attachment();

                            int bytesRead = sc.read(buf);
                            if (bytesRead == -1) {
                                System.out.println("Server closed connection.");
                                sc.close();
                                key.cancel();
                                return;
                            }

                            if (bytesRead > 0) {
                                buf.flip();
                                byte[] data = new byte[buf.remaining()];
                                buf.get(data);
                                buf.clear();

                                String msg = new String(data).trim();
                                if (!msg.isEmpty()) {
                                    System.out.println("Received from server: " + msg);

                                    if (!msg.startsWith("Echo:")) {
                                        String echo = "Echo: " + msg + "\n";
                                        ByteBuffer outBuf = ByteBuffer.wrap(echo.getBytes());
                                        while (outBuf.hasRemaining()) {
                                            sc.write(outBuf);
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
