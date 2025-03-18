public class Main {
    public static void main(String[] args) {
        Coffe coffe = new Coffe();
        SugarDecorator sugarCoffe = new SugarDecorator(coffe);
        CinnamonDecorator cinnamonSugarCoffe =
                new CinnamonDecorator(sugarCoffe);
        System.out.println(cinnamonSugarCoffe.serve());

        Beverage tea = new Tea();
        tea = new HoneyDecorator(tea);
        tea = new CinnamonDecorator(tea);
        tea = new SugarDecorator(tea);
        tea = new SugarDecorator(tea);
        System.out.println(tea.serve());
    }
}