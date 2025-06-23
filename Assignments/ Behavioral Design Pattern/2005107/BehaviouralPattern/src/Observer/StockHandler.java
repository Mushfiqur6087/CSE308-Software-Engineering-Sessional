package Observer;

import Stock.Stock;

import java.io.Serializable;
import java.util.ArrayList;

public class StockHandler implements Serializable {
    ArrayList<Stock> stocks;
    public StockHandler()
    {
        this.stocks = new ArrayList<Stock>();
    }
    public void addStock(Stock stock)
    {
        this.stocks.add(stock);
    }

    public void removeStock(Stock stock)
    {
        this.stocks.remove(stock);
    }

    public ArrayList<Stock> printStock()
    {
        return this.stocks;

    }
    boolean contains(String name)
    {
        for(Stock stock: stocks)
        {
            if(stock.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public Stock getStock(String name)
    {
        for(Stock stock: stocks)
        {
            if(stock.getName().equals(name))
            {
                return stock;
            }
        }
        return null;
    }

}
