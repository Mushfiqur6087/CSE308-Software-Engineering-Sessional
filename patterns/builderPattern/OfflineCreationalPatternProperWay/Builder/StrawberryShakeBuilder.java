package patterns.builderPattern.OfflineCreationalPatternProperWay.Builder;

import patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Candy;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Cookie;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Milk.AlmondMilk;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Shake.Shake;

public class StrawberryShakeBuilder implements ShakeBuilder{
    private final Shake myShake;
    private boolean isLactoseFree;
    private boolean isCandyAdded;
    private boolean isCookiesAdded;


    public StrawberryShakeBuilder() {

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
        //we will write our components here
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