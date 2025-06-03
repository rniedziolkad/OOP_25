package pl.umcs.oop;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    private BufferedImage image;

    public void loadImage(String filePath) {
        try {
            image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            System.err.println("Bład wczytywania pliku: " + e.getMessage());
        }
    }

    public void saveImage(String filePath) {
        try {
            String format = filePath.substring(filePath.lastIndexOf('.') + 1);
            ImageIO.write(image, format, new File(filePath));
        } catch (IOException e) {
            System.err.println("Bład zapisu: " + e.getMessage());
        }
    }

    public void increaseBrightness(int value) {
        for (int y=0; y < image.getHeight(); y++) {
            for(int x=0; x< image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb);
                int r = Math.clamp(color.getRed() + value, 0, 255);
                int g = Math.clamp(color.getGreen() + value, 0, 255);
                int b = Math.clamp(color.getBlue() + value, 0, 255);
                Color brighter = new Color(r, g, b);

                image.setRGB(x, y, brighter.getRGB());
            }
        }
    }
}
