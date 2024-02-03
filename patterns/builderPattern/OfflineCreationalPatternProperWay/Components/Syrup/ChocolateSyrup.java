package patterns.builderPattern.OfflineCreationalPatternProperWay.Components.Syrup;

public class ChocolateSyrup extends Syrup {
    @Override
    public double getPrice() {
        return 0;
    }
    @Override
    public String toString() {
        return "Chocolate Syrup";
    }
}
