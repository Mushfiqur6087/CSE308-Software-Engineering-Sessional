package Stock;

import Observer.IObserver;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Stocks implements Serializable,Stock{
    private float price;
    private String name;
    private int count;
    private String state;
    private boolean increasePrice;
    private boolean decreasePrice;
    private boolean changeCount;

    ArrayList<IObserver> observers;

    public Stocks(String name, float price, int count)
    {
        this.name = name;
        this.price = price;
        this.count = count;
        this.observers = new ArrayList<IObserver>();
    }

    private void resetState()
    {
        this.increasePrice = false;
        this.decreasePrice = false;
        this.changeCount = false;
    }
    public boolean getIncreasePrice()
    {
        return this.increasePrice;
    }
    public boolean getDecreasePrice()
    {
        return this.decreasePrice;
    }
    public boolean getChangeCount()
    {
        return this.changeCount;
    }

    public float getPrice(){
        return price;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }


    public void setPrice(float price){
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void registerObserver(IObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IObserver observer){
        this.observers.remove(observer);
    }

    public void increasePrice(float price) throws IOException {
        resetState();
        setState("increase");
        this.price += price;
        increasePrice = true;
        notifyObservers();
    }

    public void decreasePrice(float price) throws IOException {
        resetState();
        setState("decrease");
        this.price -= price;
        if(this.price < 0)
            this.price = 0;
        decreasePrice = true;
        notifyObservers();
    }

    public boolean changeCount(int count) throws IOException {
        resetState();
        if(count > 0) {
            setState("count");
            this.count = count;
            changeCount = true;
            notifyObservers();
            return true;
        }
        else
            return false;
    }

    public void notifyObservers() throws IOException {
        for(IObserver observer : observers)
        {
            observer.update(this);
        }
    }

    public void printStock()
    {
        System.out.println("Stock Name: " + this.getName() + " Stock Price: " + this.getPrice() + " Stock Count: " + this.getCount());
    }
}
