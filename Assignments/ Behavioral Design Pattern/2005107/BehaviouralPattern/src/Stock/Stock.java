package Stock;

import Observer.IObserver;

import java.io.IOException;
import java.io.Serializable;

public interface Stock extends Serializable {
    public float getPrice();
    public void setPrice(float price);
    public String getName();
    public void setName(String name);
    public int getCount();
    public String getState();
    public void setState(String state);
    public void setCount(int count);
    public void registerObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void printStock();
    public void increasePrice(float price) throws IOException;
    public void decreasePrice(float price) throws IOException;
    public boolean getChangeCount();
    public boolean getIncreasePrice();
    public boolean getDecreasePrice();
    public boolean changeCount(int count) throws IOException;


}

