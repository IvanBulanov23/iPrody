import java.io.*;
import java.net.Socket;

import static java.lang.System.in;

public class Client {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localHost", 7)) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));) {

                Thread receiverThread = new Thread(() -> {
                    try {
                        String message;
                        while ((message = in.readLine()) != null) {
                            if (message.equals("end")) {
                                System.out.println("Client close");
                                break;
                            }
                            System.out.println(message);
                            if (!message.startsWith("Echo: ")) {
                                out.println("Echo: " + message);
                            }
                        }
                        System.out.println("Server is down");
                        System.exit(0);
                    } catch (IOException e) {
                        System.out.println("Connection close");
                    }
                });

                receiverThread.start();

                String input;
                while ((input = consoleReader.readLine()) != null) {
                    out.println(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}