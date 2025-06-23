package patterns.builderPattern.OfflineCreationalPatternProperWay.Builder;


import patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Candy;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Coffee;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Cookie;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Jello.NormalJello;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Milk.AlmondMilk;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Sugar;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Shake.Shake;

public class CoffeeShakeBuilder implements ShakeBuilder{
    private final Shake myShake;
    private boolean isLactoseFree;
    private boolean isCandyAdded;
    private boolean isCookiesAdded;


    public CoffeeShakeBuilder() {

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
    public void buildShake() {
        myShake.addBaseComponents(new AlmondMilk());
        myShake.addBaseComponents(new Candy());
        myShake.addBaseComponents(new Sugar());
        myShake.addComponents(new Coffee());
        myShake.addComponents(new NormalJello());
    }

    @Override
    public void setPrice(double price) {
        myShake.setPrice(price);

    }
    public Shake getShake()
    {
        return this.myShake;
    }

}
