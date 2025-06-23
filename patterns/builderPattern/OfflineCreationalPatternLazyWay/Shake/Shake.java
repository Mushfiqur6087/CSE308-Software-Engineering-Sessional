package patterns.builderPattern.OfflineCreationalPatternLazyWay.Shake;

import patterns.builderPattern.OfflineCreationalPatternLazyWay.Components.Component;

import java.util.ArrayList;

public class Shake
{
    private String shakeType;
    private double price;
    private double added_price;
    private ArrayList<Component> base_components;
    private ArrayList<Component> added_components;

    public Shake()
    {
        base_components= new ArrayList<Component>();
        added_components=new ArrayList<Component>();
        price=0;
        added_price=0;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void addComponents(Component component)
    {
        added_components.add(component);
        added_price += component.getPrice();

    }

    public void setShakeType(String type)
    {
        this.shakeType=type;
    }

    public void removeBaseComponent()
    {
        base_components.remove(0);
    }

    public void addBaseComponents(Component component)
    {
        base_components.add(component);
        added_price += component.getPrice();

    }

    public void show()
    {
        System.out.println();
        System.out.println();
        System.out.println("Shake type:  "+shakeType);
        System.out.println("Total price: " + price+added_price);
        System.out.println("Base price: "+price);
        showBaseComponents();
        showAddedComponents();
        System.out.println();
        System.out.println("Extra Price: "+added_price);
        if(added_price!=0.0)
        {
            System.out.println("Extra Price because of special customization");
        }


    }
    public void showBaseComponents() {
        System.out.println("Base Components: ");
        int i=0;
        int size=base_components.size();
        for (Component component : base_components)
        {
            System.out.print(component);
            if(i!=size-1)
            {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println();
    }

    public void showAddedComponents() {
        System.out.println("Added Components: ");
        int j=0;
        int size=added_components.size();
        for (Component component : added_components)
        {
            System.out.print(component);
            if(j!=size-1)
            {
                System.out.print(", ");
            }
            j++;
        }
        System.out.println();
    }

    public double getPrice()
    {
        return price+added_price;
    }




}
