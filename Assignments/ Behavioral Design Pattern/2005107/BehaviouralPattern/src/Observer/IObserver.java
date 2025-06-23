package Observer;

import Stock.Stock;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public interface IObserver extends Serializable {
    public void update(Stock stock) throws IOException;
    public void subscribeStock(Stock stock);
    public void unsubscribeStock(Stock stock);
    public ArrayList<Stock> viewStocks();
    public boolean contains(String name);
    public Stock getStock(String name);
}
