import Stock.Stock;
import Stock.Stocks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Administrator {

    ArrayList<Stock> stocks;
    public Administrator()
    {
        this.stocks = new ArrayList<Stock>();
    }
    void createStock()
    {
        String filePath = "input.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String str[] =line.split(" ");
                Stock stock = new Stocks(str[0], Float.parseFloat(str[2]), Integer.parseInt(str[1]));
                stocks.add(stock);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Stock> getAllStocks()
    {
        return stocks;
    }

    Stock getStock(String name)
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

    public boolean increasePrice(String name,float price)
    {
        Stock st=null;
        for (Stock stock: stocks)
        {
            if(stock.getName().equals(name))
            {
                st=stock;
                stock.setPrice(price);
                break;
            }
        }
        return st != null;
    }

    public boolean decreasePrice(String name,float price)
    {
        Stock st2=null;
        for (Stock stock: stocks)
        {
            if(stock.getName().equals(name))
            {
                st2=stock;
                stock.setPrice(price);
                break;
            }
        }
        return st2 != null;
    }

    public boolean changeCount(String name,int count) throws IOException {
        Stock st3=null;
        boolean flag= false;
        for (Stock stock: stocks)
        {
            if(stock.getName().equals(name))
            {
                flag = stock.changeCount(count);
                break;
            }
        }
        return flag;
    }



}
