
public class Polygon {
    private final Point[] vertices;

    public Polygon(Point[] vertices) {
        this.vertices = new Point[vertices.length];
        for(int i=0; i< vertices.length; i++){
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    public Polygon(Polygon other) {
        this.vertices = new Point[other.vertices.length];
        for(int i=0; i<other.vertices.length; i++){
            this.vertices[i] = new Point(other.vertices[i]);
        }
    }

    public void setPoint(int ix, int x, int y){
        vertices[ix].setX(x);
        vertices[ix].setY(y);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Point p : vertices){
            s.append(p.getX()).append(",").append(p.getY()).append(" ");
        }
        return s.toString().trim();
    }

    public String toSvg(){
        return "<polygon points=\""
                + this
                +"\" style=\"fill:none;stroke:purple;stroke-width:3\" />";
    }
}
