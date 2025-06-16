package pl.umcs.oop.powtorzeniegui.client;

import javafx.application.Platform;
import pl.umcs.oop.powtorzeniegui.Dot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Consumer;

public class ServerThread extends Thread {
    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;
    private Consumer<Dot> drawFunction;

    public ServerThread(String address, int port) throws IOException {
        this.socket = new Socket(address, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void setDrawFunction(Consumer<Dot> drawFunction) {
        this.drawFunction = drawFunction;
    }

    public void run() {
        try {
            String message;
            while ((message=in.readLine()) != null) {
                String finalMessage = message;
                Platform.runLater(() ->
                        drawFunction.accept(Dot.fromMessage(finalMessage))
                );
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {
            }
        }
    }

    public void send(Dot point) {
        out.println(point.toMessage());
    }


}
