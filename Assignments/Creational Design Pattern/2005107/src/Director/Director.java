package Director;

import Builder.Builder;

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


}
