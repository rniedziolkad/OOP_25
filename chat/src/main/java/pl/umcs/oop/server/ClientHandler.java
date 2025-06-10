package pl.umcs.oop.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final List<ClientHandler> clients;
    private PrintWriter out;
    private String login;

    public ClientHandler(Socket socket, List<ClientHandler> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    private void broadcast(String message) {
        for (ClientHandler c : clients) {
            c.sendMessage(message);
        }
    }

    private void sendMessage(String message) {
        if (out != null) {
            out.println(message);
        }
    }

    @Override
    public void run() {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Witaj w czacie! podaj login: ");
            String message = in.readLine();
            broadcast("LOGIN "+message);
            this.login = message;
            while((message = in.readLine()) != null) {
                System.out.println("Otrzymano wiadomość: "+message);
                broadcast(this.login+": "+message);
            }

        } catch (IOException e) {
            System.err.println("Błąd komunikacji: "+ e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException _) {}

            clients.remove(this);
        }
    }
}
