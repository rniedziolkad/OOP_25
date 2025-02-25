import static java.lang.Math.pow;

public class Segment {
    public Point a, b;

    public double length(){
        return Math.sqrt(pow(a.x-b.x, 2) + pow(a.y-b.y, 2));
    }
}
