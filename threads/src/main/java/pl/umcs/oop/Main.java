package pl.umcs.oop;

public class Main {
    public static void main(String[] args) {
        ImageHandler ih = new ImageHandler();
        ih.loadImage("test.png");
        long start = System.currentTimeMillis();
        ih.increaseBrightness(0x77);
        long end = System.currentTimeMillis();
        ih.saveImage("out.png");

        System.out.println("czas na 1 wątku: "+(end-start) + "ms");
    }
}