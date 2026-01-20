import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String userName;

    public ClientHandler(Socket socket) {
        this.socket = socket;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("Enter your name:");
            userName = reader.readLine();
            writer.println("Welcome " + userName + "!");

            ChatServer.broadcast(userName + " joined the chat", this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;

        try {
            while ((message = reader.readLine()) != null) {
                System.out.println(userName + ": " + message);
                ChatServer.broadcast(userName + ": " + message, this);
            }
        } catch (Exception e) {
            System.out.println(userName + " disconnected");
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }
}
