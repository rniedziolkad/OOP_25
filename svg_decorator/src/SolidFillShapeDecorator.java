public class SolidFillShapeDecorator extends ShapeDecorator {
    private final String color;

    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public String toSvg(String inputSvg) {
        return super.toSvg(String.format("fill=\"%s\" %s", color, inputSvg));
    }
}
