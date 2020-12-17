package week2.day3.servertest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 4000;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Awaiting for a client...");
        Socket client = serverSocket.accept();
        System.out.println(client.isConnected());
        System.out.println("Client connected. Port: " + client.getPort());
        System.out.println(client.getInetAddress());
        System.out.println(client.getLocalPort());
        System.out.println(client.getLocalAddress());
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String word = in.readLine();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        out.write("Server launch\n");
        out.write(word);
        out.flush();
        System.out.println(word);

        out.write("Server close\n");
        out.flush();
        client.close();
        in.close();

        out.close();

        serverSocket.close();

    }
}