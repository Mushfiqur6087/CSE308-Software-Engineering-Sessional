package patterns.builderPattern.example4.Components;

public class Cookie implements Component
{
    @Override
    public double getPrice() {
        return 40.0;
    }
    @Override
    public String toString() {
        return "Cookie";
    }
}
