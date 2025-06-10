package pl.umcs.oop.powtorzeniegui.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private final static List<ClientThread> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            while(true) {
                System.out.println("Czekam na połączenie...");
                Socket accepted = serverSocket.accept();
                System.out.println("Połączono: "+accepted);
                ClientThread ct = new ClientThread(accepted);
                clients.add(ct);
                ct.start();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void broadcast(String message) {
        for (ClientThread client : clients){
            client.send(message);
        }
    }
}
