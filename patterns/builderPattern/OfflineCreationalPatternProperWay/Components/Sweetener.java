package patterns.builderPattern.OfflineCreationalPatternProperWay.Components;

public class Sweetener implements Component {

    @Override
    public double getPrice() {
        return 0;
    }
    @Override
    public String toString() {
        return "Sweetener";
    }

}
