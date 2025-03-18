public interface Shape {
    BoundingBox boundingBox();
    String toSvg(String inputSvg);
    // default -- domyślna implementacja, nie trzeba zmieniać
    default String toSvg() {
        return toSvg("");
    }
}
