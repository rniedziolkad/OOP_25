import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Point p1 = new Point();
        p1.setX(30.0);
        p1.setY(24.0);

        System.out.println(p1);

        Point p2 = new Point(13.0, 65);
        System.out.println(p2);

        Segment s1 = new Segment(p1, p2);
        System.out.println(s1);

        p2.setX(45);
        System.out.println(s1);

        Point[] arr = {p1, p2, p1};
        arr[2] = new Point(30, 65);

        // tworzenie stylu
        Style style = new Style("red", "black", 2.0);
        Polygon poly = new Polygon(arr, style);
        System.out.println(poly);

        p1.setX(60);
        System.out.println(poly);
        System.out.println(poly.toSvg());


        SvgScene scene = new SvgScene();
        scene.addPolygon(poly);
        Polygon polyCopy = new Polygon(poly);
        scene.addPolygon(polyCopy);
        polyCopy.setPoint(0, -40, -40);
        polyCopy.setPoint(1, 0, 30);
        polyCopy.setPoint(2, 40, 0);

        Polygon square = new Polygon(new Point[]{
                new Point(40, 40),
                new Point(40, 90),
                new Point(90, 90),
                new Point(90, 40)
        });
        scene.addPolygon(square);
        System.out.println("Scene:");
        System.out.println(scene.toSvg());

        // tworzenie kwadratu
        Segment diag = new Segment(new Point(100, 100), new Point(140, 140));
        Polygon squre2 = Polygon.square(diag, style);
        System.out.println("square2: "+squre2);
        scene.addPolygon(squre2);

        // TODO: tworzenie elipsy
        // środek elispy (punkt), rx, ry, style
//        Ellipse ellipse = new Ellipse(new Point(-50, -50), 30, 30, style);
//        System.out.println(ellipse);
//        scene.addPolygon(ellipse);

        System.out.println(polyCopy.boundingBox());
        scene.save("rysunek.svg");
    }


}