import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 2000);
            System.out.print("Enter your username: ");
            String username = keyb.nextLine();
            Client client = new Client(username, socket);
            client.start();  
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
