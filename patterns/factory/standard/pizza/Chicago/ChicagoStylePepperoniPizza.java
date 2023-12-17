package patterns.factory.standard.pizza.Chicago;

import patterns.factory.standard.pizza.Pizza;

public class ChicagoStylePepperoniPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("Preparing `Chicago Style Pepperoni Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking Chicago Style Pepperoni Pizza...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Chicago Style Pepperoni Pizza...");
    }

    @Override
    public void box() {
        System.out.println("Boxing Chicago Style Pepperoni Pizza...");
    }
}
