package patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Jello;

public class SugarFreeJello extends Jello
{
    @Override
    public double getPrice() {
        return 0;
    }
    @Override
    public String toString() {
        return "Normal Jello";
    }

}
