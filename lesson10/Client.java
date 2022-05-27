import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private String username;
    private static final Scanner keyb = new Scanner(System.in);
    private Socket socket;
    private static String ANSI_RESET = "\u001B[0m";
    private static String ANSI_GREEN = "\u001B[32m";
    private static String ANSI_RED = "\u001B[31m";
    private static String ANSI_BLUE = "\u001B[34m";

    // constructor
    public Client(String username, Socket socket) {
        this.username = username;
        this.socket = socket;
    }

    private void serverReader() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message = "";
            while (true) {
                message = reader.readLine();
                if (message.equals("#exit")) {
                    System.out.println(ANSI_RED + "You left the chat!" + ANSI_RESET);
                    socket.close();
                    break;
                }
                System.out.println(message);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private void serverWriter() {
        try (PrintStream pstStream = new PrintStream(socket.getOutputStream())) {
            pstStream.println(ANSI_BLUE +  username + " is joined!" + ANSI_GREEN);
            String message = keyb.nextLine();
            while (!message.equals("#exit")) {
                message = username + ": " + message;
                pstStream.println(ANSI_RESET + message + ANSI_GREEN);
                message = keyb.nextLine();
            }
            pstStream.println(ANSI_RED +  username + " has left!" + ANSI_RESET);
            pstStream.println(message);
            pstStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    

    public void start() {
        
        Thread reader = new Thread(new Runnable() {
            @Override
            public void run() {
                serverReader();
            }
        });

        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                serverWriter();
            }
        });

        reader.start();
        writer.start();
    }
}
