package patterns.factory.standard.store;

//import patterns.factory.standard.pizza.NY.NYStyleCheesePizza;
//import patterns.factory.standard.pizza.NY.NYStylePepperoniPizza;
import patterns.factory.standard.pizza.Pizza;
import patterns.factory.standard.pizza.Chicago.ChicagoStyleCheesePizza;
import patterns.factory.standard.pizza.Chicago.ChicagoStylePepperoniPizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else {
            return null;
        }
    }
}
