import java.io.FileWriter;
import java.io.IOException;

public class SvgScene {
    private final Polygon[] polygons;
    private int ix;

    public SvgScene() {
        this.polygons = new Polygon[3];
        ix = 0;
    }

    public void addPolygon(Polygon polygon) {
        polygons[ix] = polygon;
        ix = (ix+1) % polygons.length;
    }

    public String toSvg() {
        StringBuilder sb = new StringBuilder();
        for(Polygon p: polygons){
            if(p != null)
                sb.append(p.toSvg()).append("\n");
        }
        return sb.toString();
    }

    public BoundingBox boundingBox() {
        double minX = Double.POSITIVE_INFINITY;
        double maxX = Double.NEGATIVE_INFINITY;
        double minY = Double.POSITIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;
        for (Polygon p: polygons){
            if (p!=null) {
                BoundingBox bb = p.boundingBox();
                minX = Math.min(minX, bb.x());
                minY = Math.min(minY, bb.y());
                maxX = Math.max(maxX, bb.x()+bb.width());
                maxY = Math.max(maxY, bb.y()+bb.height());
            }
        }
        return new BoundingBox(minX, minY, maxX-minX, maxY-minY);
    }

    public void save(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        BoundingBox bb = boundingBox();
        writer.write("<svg width=\""+bb.width()+"\" height=\""+bb.height());
        writer.write("\" viewBox=\""+bb.x()+" "+bb.y()+" "+bb.width()+" "+bb.height()+"\" xmlns=\"http://www.w3.org/2000/svg\">");
        for(Polygon p : polygons){
            writer.write(p.toSvg()+"\n");
        }
        writer.write("</svg>");
        writer.close();
    }

}
