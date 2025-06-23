import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import SocketWrapper.*;

import Observer.IObserver;
import Observer.Observer;
import SocketWrapper.SocketWrapper;
import Stock.Stock;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = null;
        ServerSocket server = new ServerSocket(3000);
        System.out.println("Server is listening on port 3000");
        Administrator admin = new Administrator();
        admin.createStock();
        while (true) {
            clientSocket = server.accept();
            SocketWrapper client = new SocketWrapper(clientSocket);
            System.out.println("New client connected");
            new Thread(() -> {
                try {
                    String name = (String) client.read();
                    System.out.println(name+" connected");
                    Observer observer = new Observer(name, client);



                    while (true) {
                        Object o =client.read();
                        String str = (String) o;
                        if(str.equals("viewAll"))
                        {
                            client.write(new DataWrapper("viewAll", admin.getAllStocks()));
                        }
                        if(str.equals("viewMyStock"))
                        {

                            client.write(new DataWrapper("yourStock", observer.viewStocks()));
                        }
                        if(str.contains("buy"))
                        {
                            String []arr = str.split(" ");
                            Stock stockName = admin.getStock(arr[1]);
                            if(stockName!=null && !observer.contains(arr[1]))
                            {
                                observer.subscribeStock(stockName);
                                stockName.registerObserver(observer);
                                System.out.println(name+" bought "+stockName.getName());
                                client.write(new DataWrapper("success-buy", "Stock bought successfully"));
                            }
                            else
                            {
                                if(stockName==null)
                                    client.write(new DataWrapper("error", "Stock not found"));
                                else
                                    client.write(new DataWrapper("error", "You already have this stock"));
                            }

                        }
                        if(str.contains("sell"))
                        {
                            String []arr = str.split(" ");
                            Stock stockName = observer.getStock(arr[1]);
                            if(stockName!=null)
                            {
                                observer.unsubscribeStock(stockName);
                                stockName.removeObserver(observer);
                                System.out.println(name+" sold "+stockName.getName());
                                client.write(new DataWrapper("success-sell", "Stock sold successfully"));
                            }
                            else
                            {
                                client.write(new DataWrapper("error", "You don't have this stock"));
                            }

                        }

                        if(str.contains("increase"))
                        {
                            boolean flag;
                            String[]arr = str.split(" ");
                            flag=admin.increasePrice(arr[1],Float.parseFloat(arr[2]));
                            if(flag)
                                client.write(new DataWrapper("increase",name+" increased  price to "+arr[2]));

                            else
                                client.write(new DataWrapper("error", "Stock not found"));

                        }

                        if(str.contains("decrease"))
                        {
                            boolean flag;
                            String[]arr = str.split(" ");
                            flag=admin.decreasePrice(arr[1],Float.parseFloat(arr[2]));
                            if(flag)
                                client.write(new DataWrapper("decrease",name+" decreased price to "+arr[2]));
                            else
                                client.write(new DataWrapper("error", "Stock not found"));

                        }

                        if(str.contains("changeCount"))
                        {
                            boolean flag;
                            String[]arr = str.split(" ");
                            flag=admin.changeCount(arr[1],Integer.parseInt(arr[2]));
                            if (flag)
                                client.write(new DataWrapper("change",name+" changed count to "+arr[2]));
                            else
                                client.write(new DataWrapper("error", "Stock not found or tried to change count to negative value"));
                        }


                    }


                } catch (SocketException e) {
                    System.out.println("Client disconnected");
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}


