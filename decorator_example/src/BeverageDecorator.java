public abstract class BeverageDecorator implements Beverage {
    private Beverage decoratedBeverage;

    public BeverageDecorator(Beverage decoratedBeverage) {
        this.decoratedBeverage = decoratedBeverage;
    }

    @Override
    public String serve() {
        return decoratedBeverage.serve();
    }
}
