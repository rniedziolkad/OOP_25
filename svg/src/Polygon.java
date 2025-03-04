import java.util.Arrays;

public class Polygon {
    private final Point[] vertices;

    public Polygon(Point[] vertices) {
        this.vertices = new Point[vertices.length];
        for(int i=0; i< vertices.length; i++){
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "vertices=" + Arrays.toString(vertices) +
                '}';
    }
}
