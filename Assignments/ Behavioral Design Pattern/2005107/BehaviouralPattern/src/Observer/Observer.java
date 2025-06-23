package Observer;

import Stock.Stock;
import SocketWrapper.SocketWrapper;
import SocketWrapper.DataWrapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Observer implements Serializable,IObserver {
    String name;
    StockHandler st;
    SocketWrapper socketWrapper;
    public Observer(String name,SocketWrapper socketWrapper)
    {
        this.socketWrapper = socketWrapper;
        this.name = name;
        this.st = new StockHandler();
    }
    public  void update(Stock stock) throws IOException {
        if(stock.getIncreasePrice())
        {
            socketWrapper.write(new DataWrapper("increase",stock.getName()+" price increased to "+stock.getPrice()+" "+stock.getCount()));

        }
        else if (stock.getDecreasePrice())
        {
            socketWrapper.write(new DataWrapper("decrease",stock.getName()+" price decreased to "+stock.getPrice()+" "+stock.getCount()));

        }
        else if (stock.getChangeCount())
        {
            socketWrapper.write(new DataWrapper("change",stock.getName()+" count changed to "+stock.getPrice()+" "+stock.getCount()));
        }

    }
    public void subscribeStock(Stock stock)
    {
        this.st.addStock(stock);
    }
    public void unsubscribeStock(Stock stock)
    {
        this.st.removeStock(stock);
    }
    public ArrayList<Stock> viewStocks()
    {
        return this.st.printStock();

    }
    public boolean contains(String name)
    {
        return this.st.contains(name);
    }
    public Stock getStock(String name)
    {
        return this.st.getStock(name);
    }
}
