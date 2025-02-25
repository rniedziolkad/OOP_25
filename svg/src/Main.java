
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Point p1 = new Point();
        p1.x = 30.0;
        p1.y = 24.0;

        System.out.println(p1);
        System.out.println(p1.toSvg());

        p1.translate(-6, 5);
        System.out.println(p1);
        Point tr = p1.translated(6, -5);
        System.out.println(tr);
        // taki sam jak tr
        System.out.println(p1.translated(6, -5));

        Segment segment = new Segment();
        segment.a = new Point();
        segment.a.x = 0.0;
        segment.a.y = 0.0;
        segment.b = new Point();
        segment.b.x = 4.0;
        segment.b.y = 3.0;

        System.out.println(segment.length());
        Segment[] segments = new Segment[2];
        segments[0] = segment;

        segments[1] = new Segment();
        segments[1].a = new Point();
        segments[1].b = new Point();
        segments[1].a.x = 0.0;
        segments[1].a.y = 0.0;
        segments[1].b.x = 7.5;
        segments[1].b.y = 5.0;

        // segment.maxSegment(segments); tak nie robimy, metoda statyczna
        Segment result = Segment.maxSegment(segments); //wywołujemy na rzecz klasy
        System.out.println("Najdluższy: "+result.length());

    }


}