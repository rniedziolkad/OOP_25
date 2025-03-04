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

}
