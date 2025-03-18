public abstract class ShapeDecorator implements Shape {
    private Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public BoundingBox boundingBox() {
        if (decoratedShape == null)
            return null;
        return decoratedShape.boundingBox();
    }

    @Override
    public String toSvg(String inputSvg) {
        if (decoratedShape == null)
            return "";
        return decoratedShape.toSvg(inputSvg);
    }
}
