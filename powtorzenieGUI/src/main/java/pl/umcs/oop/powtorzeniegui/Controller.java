package pl.umcs.oop.powtorzeniegui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.umcs.oop.powtorzeniegui.client.ServerThread;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField addressField;
    @FXML
    private TextField portField;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Canvas canvas;
    @FXML
    private Slider radiusSlider;

    private ServerThread serverThread;


    @FXML
    private void onStartServerClicked() {
        System.err.println("onStartServerClicked not implemented!");
    }

    @FXML
    private void onConnectClicked() {
        if(serverThread != null && serverThread.isAlive()) {
            System.err.println("Już połączono!");
            return;
        }
        String address = addressField.getText().trim();
        int port = Integer.parseInt(portField.getText().trim());
        try {
            ServerThread newThread = new ServerThread(address, port);

            newThread.setDrawFunction(dot -> {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.setFill(dot.color());
                gc.fillOval(
                        dot.x()-dot.radius(),
                        dot.y()-dot.radius(),
                        dot.radius()*2,
                        dot.radius()*2
                );
            });

            newThread.start();
            this.serverThread = newThread;
        } catch (IOException e) {
            System.err.println("Błąd połączenia z serwerem: "+e.getMessage());
        }
    }

    @FXML
    private void onMouseClicked(MouseEvent e) {
        double x = e.getX();
        double y =e.getY();
        double radius = radiusSlider.getValue();
        Color color = colorPicker.getValue();

        System.err.println("Kilknieto: ("+x+", "+y+")");

        Dot point = new Dot(x, y, radius, color);

        if (serverThread != null && serverThread.isAlive()) {
            serverThread.send(point);
        } else {
            System.err.println("Połącz się z serwerem!");
        }
    }



}
