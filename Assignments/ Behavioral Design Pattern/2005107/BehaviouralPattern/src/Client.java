import SocketWrapper.SocketWrapper;
import Stock.Stock;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;
import SocketWrapper.DataWrapper;

public class Client {
    static String menu2 = "1. Buy Stock\n2. Sell Stock\n3. View All Stock\n4. View Your Stock\n5. Exit\nEnter your choice: ";
    public static void runThread(SocketWrapper server)
    {
        new Thread(() -> {
            try {


                while (true) {
                    Object o = server.read();
                    DataWrapper data = (DataWrapper) o;

                    if (data.command.equals("viewAll"))
                    {
                        ArrayList<Stock> stocks = (ArrayList<Stock>) data.data;
                        for (Stock stock : stocks) {
                            stock.printStock();
                        }
                        System.out.println(menu2);
                    }
                    if (data.command.equals("yourStock"))
                    {
                        ArrayList<Stock> stocks = (ArrayList<Stock>) data.data;
                        for (Stock stock : stocks) {
                            stock.printStock();
                        }
                        if(stocks.isEmpty())
                        {
                            System.out.println("You have no stocks");
                        }
                        System.out.println(menu2);
                    }
                    if(data.command.equals("success-buy"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                        System.out.println(menu2);
                    }
                    if(data.command.equals("success-sell"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                        System.out.println(menu2);
                    }
                    if(data.command.equals("error"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                    }
                    if(data.command.equals("increase"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                    }

                    if(data.command.equals("decrease"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                    }
                    if(data.command.equals("changeCount"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                    }


                }


            } catch (SocketException e) {
                System.out.println("Client disconnected");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }).start();

    }
    public static void main(String[] args) throws IOException {
        SocketWrapper server = new SocketWrapper("127.0.0.1", 3000);
        String menu = "Enter username: ";
        System.out.print(menu);
        Scanner scn = new Scanner(System.in);
        String username = scn.nextLine();
        server.write(username);
        runThread(server);
        System.out.println(menu2);
        while (true)
        {
            int choice = scn.nextInt();
            switch (choice)
            {
                case 3:
                    server.write("viewAll");
                    break;
                case 4:
                    server.write("viewMyStock");
                    break;
                case 5:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Enter stock name: ");
                    String stockName = scn.next();
                    server.write("buy "+stockName);
                    break;
                case 2:
                    System.out.print("Enter stock name: ");
                    String stockName2 = scn.next();
                    server.write("sell "+stockName2);
                    break;
            }


        }
    }
}
