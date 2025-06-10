package pl.umcs.oop.powtorzeniegui;

import javafx.scene.paint.Color;

public record Dot(double x, double y, double radius, Color color) {
    public static Dot fromMessage(String message) {
        String[] parts = message.split(",");
        double x = Double.parseDouble(parts[0]);
        double y = Double.parseDouble(parts[1]);
        double radius = Double.parseDouble(parts[2]);
        Color color = Color.valueOf(parts[3]);

        return new Dot(x, y, radius, color);
    }

    public String toMessage() {
        return this.x+","+this.y+","+this.radius+","+this.color;
    }
}
