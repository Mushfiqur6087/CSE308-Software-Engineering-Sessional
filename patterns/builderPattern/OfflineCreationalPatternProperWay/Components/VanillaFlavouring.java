package patterns.builderPattern.OfflineCreationalPatternProperWay.Components;

public class VanillaFlavouring implements Component {
    @Override
    public double getPrice() {
        return 0;
    }
    @Override
    public String toString() {
        return "Vanilla Flavouring";
    }

}
