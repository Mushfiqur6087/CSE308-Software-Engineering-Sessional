package patterns.factory.standard;
import patterns.factory.standard.pizza.Pizza;
import patterns.factory.standard.store.ChicagoPizzaStore;
import patterns.factory.standard.store.NYPizzaStore;
import patterns.factory.standard.store.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza pepperoniPizza = nyPizzaStore.orderPizza("pepperoni");
        Pizza cheesePizza = nyPizzaStore.orderPizza("cheese");
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        Pizza pepperoniPizza2 = chicagoPizzaStore.orderPizza("pepperoni");
        Pizza cheesePizza2 = chicagoPizzaStore.orderPizza("cheese");
    }
}
