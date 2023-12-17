package patterns.builderPattern.example4.Components;

public class Coffee implements Component{
    @Override
    public double getPrice() {
        return 0;
    }
    @Override
    public String toString() {
        return "Coffee";
    }
}
