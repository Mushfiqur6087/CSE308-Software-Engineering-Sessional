import SocketWrapper.SocketWrapper;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;
import SocketWrapper.DataWrapper;
import Stock.Stock;

public class StockAdministrator {
    static String menu2 = "1. Increase Price\n2. Decrease Price\n3. Change Count\nEnter your choice: ";
    public static void runThread(SocketWrapper server)
    {
        new Thread(() -> {
            try {


                while (true) {
                    Object o = server.read();
                    DataWrapper data = (DataWrapper) o;

                    if(data.command.equals("increase"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                        System.out.println(menu2);
                    }
                    if(data.command.equals("decrease"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                        System.out.println(menu2);
                    }
                    if(data.command.equals("change"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                        System.out.println(menu2);
                    }

                    if(data.command.equals("error"))
                    {
                        String str= (String) data.data;
                        System.out.println(data.data);
                        System.out.println(menu2);
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
        server.write("admin");
        runThread(server);
        Scanner scn = new Scanner(System.in);
        System.out.println(menu2);
        while (true)
        {
            int choice = scn.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter stock name: ");
                    String name = scn.next();
                    System.out.println("Enter price to increase: ");
                    float price = scn.nextFloat();
                    server.write("increase "+name+" "+price);
                    break;
                case 2:
                    System.out.println("Enter stock name: ");
                    String name1 = scn.next();
                    System.out.println("Enter price to decrease: ");
                    float price1 = scn.nextFloat();
                    server.write("decrease "+name1+" "+price1);
                    break;
                case 3:
                    System.out.println("Enter stock name: ");
                    String name2 = scn.next();
                    System.out.println("Enter count to change: ");
                    int count = scn.nextInt();
                    server.write("changeCount "+name2+" "+count);
                    break;

            }
        }
    }
}