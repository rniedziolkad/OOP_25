public class CinnamonDecorator extends BeverageDecorator {

    public CinnamonDecorator(Beverage decoratedBeverage) {
        super(decoratedBeverage);
    }
    @Override
    public String serve() {
        return super.serve() + " + cynamon";
    }
}
