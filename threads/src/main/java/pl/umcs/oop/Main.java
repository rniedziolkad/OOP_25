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

        ih.loadImage("test.png");
        long start2 = System.currentTimeMillis();
        ih.increaseBrightnessMultiThreaded(0x77);
        long end2 = System.currentTimeMillis();
        ih.saveImage("out.png");
        System.out.println("czas na wielu wątkach: "+(end2-start2) + "ms");

        ih.loadImage("test.png");
        long start3 = System.currentTimeMillis();
        ih.increaseBrightnessThreadPool(0x77);
        long end3 = System.currentTimeMillis();
        ih.saveImage("out.png");
        System.out.println("czas na wielu wątkach: "+(end3-start3) + "ms");
    }
}