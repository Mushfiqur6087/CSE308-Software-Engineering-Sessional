package Components;

public class Candy implements Component
{
    @Override
    public double getPrice() {
        return 50.0;
    }
    @Override
    public String toString() {
        return "Candy";
    }
}
