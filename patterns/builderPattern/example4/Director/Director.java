package patterns.builderPattern.example4.Director;
import patterns.builderPattern.example4.Builder.Builder;

public class Director
{
    public void chocolateShake( Builder builder)
    {
        builder.setShakeType("Chocolate Shake");
        builder.setPrice(230.0);
        builder.addMilk();
        builder.addSugar();
        builder.addChocolateSyrup();
        builder.addChocolateIceCream();

    }

    public void coffeeShake( Builder builder)
    {
        builder.setShakeType("Coffee Shake");
        builder.setPrice(250.0);
        builder.addMilk();
        builder.addSugar();
        builder.addCoffee();
        builder.addNormalJello();

    }

    public void strawberryShake( Builder builder)
    {
        builder.setShakeType("Strawberry Shake");
        builder.setPrice(200.0);
        builder.addMilk();
        builder.addSugar();
        builder.addStrawberrySyrup();
        builder.addStrawberryIceCream();

    }

    public void vanillaShake( Builder builder)
    {
        builder.setShakeType("Vanilla Shake");
        builder.setPrice(190.0);
        builder.addMilk();
        builder.addSugar();
        builder.addVanillaFlavouring();
        builder.addNormalJello();

    }

    public void zeroShake( Builder builder)
    {
        builder.setShakeType("Zero Shake");
        builder.setPrice(240.0);
        builder.addMilk();
        builder.addSweetener();
        builder.addVanillaFlavouring();
        builder.addSugarFreeJello();

    }


    //we could implement a better approach in this director class. modify this function to
    public void zeroShake2(Builder builder,Boolean isCondition1,Boolean isCondition2,Boolean isCondition3)
    {
        //build zero shake with condition

    }
    public void vanillaShake2(Builder builder,Boolean isCondition1,Boolean isCondition2,Boolean isCondition3)
    {
        //build vanilla shakes with condition
    }
//!,,,,,,,,,,,,,,,,,,,,
//we also need to modify orderSystem class

}
