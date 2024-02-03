package patterns.builderPattern.OfflineCreationalPatternLazyWay.Builder;

import patterns.builderPattern.OfflineCreationalPatternLazyWay.Shake.Shake;

public interface Builder
{
    public void setShakeType(String type);

    public boolean makeLactoseFree();

    public boolean addCandyOnTop();

    public boolean addCookiesOnTop();

    public void addSugar();

    public void addChocolateIceCream();

    public void addStrawberryIceCream();

    public void addNormalJello();

    public void addSugarFreeJello();

    public void addMilk();

    public void addChocolateSyrup();

    public void addStrawberrySyrup();

    public void addCoffee();

    public void addSweetener();

    public void addVanillaFlavouring();

    public void setPrice(double price);
    public Shake getShake();
    //public void show();
}




