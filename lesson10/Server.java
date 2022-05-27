import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable{

    private static ArrayList<Server> servers = new ArrayList<>(); // for keeping the sockets
    private Socket socket;
    private PrintStream pStream;


    // constructor
    public Server(Socket socket) {
        this.socket = socket;
        servers.add(this);
        try {
            pStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("A client is connected with port: " + socket.getPort());
    }

    public PrintStream getpStream() {
        return pStream;
    }


    @Override
    public void run() {
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // for reading from the client
            String message = bReader.readLine();
            while (!message.equals("#exit")) {
                writer(message);
                message = bReader.readLine();
            }
            getpStream().println(message);
            servers.remove(this);
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private void writer(String message) {
        for (Server server : servers) {
            if (!server.equals(this))
                server.getpStream().println(message);
        }
    }


    public static void main(String[] args) {
        Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(2000);
            while (true) {
                socket = serverSocket.accept();
                Thread thread = new Thread(new Server(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}