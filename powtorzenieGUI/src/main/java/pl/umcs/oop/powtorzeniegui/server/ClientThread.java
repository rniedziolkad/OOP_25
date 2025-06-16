package pl.umcs.oop.powtorzeniegui.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientThread extends Thread {
    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void send(String message) {
        out.println(message);
    }

    public void run() {
        System.out.println(socket+": wątek wystartował! Czytanie...");
        try {
            String message;
            while ((message = in.readLine()) != null){
                System.out.println("Otrzymano: "+message);
                Server.broadcast(message);
            }

        } catch (IOException e) {
            System.err.println(socket + ": " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
            Server.removeClient(this);
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
