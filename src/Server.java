import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(7);
            Socket socket = serverSocket.accept();
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));) {

                Thread thread1 = new Thread(() -> {
                    try {
                        String message;
                        while ((message = in.readLine()) != null) {
                            if (message.equals("end")) {
                                System.out.println("Server close");
                                break;
                            }
                            System.out.println(message);
                            if (!message.startsWith("Echo: ")) {
                                out.println("Echo: " + message);
                            }
                        }
                        System.exit(0);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                thread1.start();

                String input;
                while ((input = console.readLine()) != null) {
                    out.println(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

