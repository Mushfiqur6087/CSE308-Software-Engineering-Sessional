package patterns.builderPattern.OfflineCreationalPatternLazyWay.Components.Milk;

public class AlmondMilk extends Milk{
    @Override
    public double getPrice() {
        return 60.0;
    }
    @Override
    public String toString() {
        return "Almond Milk";
    }

}
