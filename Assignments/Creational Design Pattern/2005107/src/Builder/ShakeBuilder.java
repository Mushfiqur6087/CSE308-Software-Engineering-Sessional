package Builder;

import Components.*;
import Components.IceCeam.ChocolateIceCream;
import Components.IceCeam.StrawberryIceCream;
import Components.Jello.NormalJello;
import Components.Jello.SugarFreeJello;
import Components.Milk.AlmondMilk;
import Components.Milk.RegularMilk;
import Components.Syrup.ChocolateSyrup;
import Components.Syrup.StrawberrySyrup;
import Shake.Shake;

public class ShakeBuilder implements Builder {
    private Shake myShake;
    private boolean isLactoseFree;
    private boolean isCandyAdded;
    private boolean isCookiesAdded;


    public ShakeBuilder() {

        myShake = new Shake();
        isLactoseFree=false;
        isCandyAdded=false;
        isCookiesAdded=false;
    }

    @Override
    public void setShakeType(String type) {
        myShake.setShakeType(type);
    }

    @Override
    public boolean makeLactoseFree()
    {
        if(!isLactoseFree) {
            myShake.removeBaseComponent();
            myShake.addBaseComponents(new AlmondMilk());
            isLactoseFree = true;
            return true;
        }
        else
            return false;

    }

    @Override
    public boolean addCandyOnTop()
    {
        if(!isCandyAdded) {
            myShake.addComponents(new Candy());
            isCandyAdded=true;
            return true;
        }
        else
            return false;


    }

    @Override
    public boolean addCookiesOnTop() {
        if(!isCookiesAdded) {
            myShake.addComponents(new Cookie());
            isCookiesAdded=true;
            return true;
        }
        else
            return false;

    }

    @Override
    public void addSugar() {
        myShake.addBaseComponents(new Sugar());
    }

    @Override

    public void addChocolateIceCream() {
        myShake.addComponents(new ChocolateIceCream());

    }

    @Override
    public void addStrawberryIceCream()
    {
        myShake.addComponents(new StrawberryIceCream());
    }

    @Override

    public void addNormalJello()
    {
        myShake.addComponents(new NormalJello());

    }

    @Override
    public void addSugarFreeJello()
    {
        myShake.addComponents(new SugarFreeJello());


    }


    @Override
    public void addMilk()
    {
        myShake.addBaseComponents(new RegularMilk());

    }

    @Override

    public void addChocolateSyrup()
    {
        myShake.addComponents(new ChocolateSyrup());

    }

    @Override
    public void addStrawberrySyrup() {
        myShake.addComponents(new StrawberrySyrup());

    }

    @Override

    public void addCoffee() {
        myShake.addComponents(new Coffee());
    }

    @Override

    public void addSweetener() {
        myShake.addBaseComponents(new Sweetener());

    }

    @Override
    public void addVanillaFlavouring() {
        myShake.addComponents(new VanillaFlavouring());

    }

    @Override
    public void setPrice(double price) {
        myShake.setPrice(price);

    }

    public Shake getShake()
    {
        return this.myShake;
    }
//    @Override
//    public void show()
//    {      myShake.show();}



}
