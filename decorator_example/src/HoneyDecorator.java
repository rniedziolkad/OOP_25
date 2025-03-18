public class HoneyDecorator extends BeverageDecorator {
    public HoneyDecorator(Beverage decoratedBeverage) {
        super(decoratedBeverage);
    }

    @Override
    public String serve() {
        return super.serve() + " + miód";
    }
}
