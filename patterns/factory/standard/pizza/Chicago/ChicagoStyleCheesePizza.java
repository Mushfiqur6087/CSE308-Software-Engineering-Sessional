package patterns.factory.standard.pizza.Chicago;

import patterns.factory.standard.pizza.Pizza;

//import java.util.ArrayList;
//import java.util.List;

public class ChicagoStyleCheesePizza extends Pizza {

    @Override
    public void prepare() {
//        this.toppings.add("Cheese");
//        this.toppings.add("Cheese");
        System.out.println("Preparing `Chicago Style Cheese Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Chicago Style Cheese Pizza...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Chicago Style Cheese Pizza...");
    }

    @Override
    public void box() {
        System.out.println("Boxing Chicago Style Cheese Pizza...");
    }
}
