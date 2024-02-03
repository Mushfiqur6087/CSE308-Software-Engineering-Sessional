package patterns.builderPattern.OfflineCreationalPatternProperWay.Director;
import patterns.builderPattern.OfflineCreationalPatternProperWay.Builder.ShakeBuilder;

public class Director
{
    public void chocolateShake( ShakeBuilder builder,boolean Condition1,boolean Condition2,boolean Condition3)

    {
        builder.setShakeType("Chocolate Shake");
        builder.setPrice(230.0);
        builder.buildShake();
        if(Condition1)
            builder.makeLactoseFree();
        if(Condition2)
            builder.addCandyOnTop();
        if(Condition3)
            builder.addCookiesOnTop();
    }

    public void coffeeShake( ShakeBuilder builder,boolean Condition1,boolean Condition2,boolean Condition3)
    {
        builder.setShakeType("Coffee Shake");
        builder.setPrice(250.0);
        builder.buildShake();
        if(Condition1)
            builder.makeLactoseFree();
        if(Condition2)
            builder.addCandyOnTop();
        if(Condition3)
            builder.addCookiesOnTop();
    }

    public void strawberryShake( ShakeBuilder builder,boolean Condition1,boolean Condition2,boolean Condition3)
    {
        builder.setShakeType("Strawberry Shake");
        builder.setPrice(200.0);
        builder.buildShake();
        if(Condition1)
            builder.makeLactoseFree();
        if(Condition2)
            builder.addCandyOnTop();
        if(Condition3)
            builder.addCookiesOnTop();

    }

    public void vanillaShake( ShakeBuilder builder,boolean Condition1,boolean Condition2,boolean Condition3)
    {
        builder.setShakeType("Vanilla Shake");
        builder.setPrice(190.0);
        builder.buildShake();
        if(Condition1)
            builder.makeLactoseFree();
        if(Condition2)
            builder.addCandyOnTop();
        if(Condition3)
            builder.addCookiesOnTop();

    }

    public void zeroShake( ShakeBuilder builder,boolean Condition1,boolean Condition2,boolean Condition3)
    {
        builder.setShakeType("Zero Shake");
        builder.setPrice(240.0);
        builder.buildShake();
        builder.addCookiesOnTop();
        if(Condition1)
            builder.makeLactoseFree();
        if(Condition2)
            builder.addCandyOnTop();
        if(Condition3)
            builder.addCookiesOnTop();
    }

}