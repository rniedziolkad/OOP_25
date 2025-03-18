public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage decoratedBeverage) {
        super(decoratedBeverage);
    }

    @Override
    public String serve() {
        return super.serve() + " + cukier";
    }
}
