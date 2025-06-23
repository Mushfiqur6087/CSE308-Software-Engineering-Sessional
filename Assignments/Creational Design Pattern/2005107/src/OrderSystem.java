import Builder.ShakeBuilder;
import Director.Director;
import Shake.Shake;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderSystem {
    private boolean openOrder;

    private ArrayList<Shake> orderedShakes;
    private final Director director;
    private ShakeBuilder builder;
    private Shake currentShake;

    public OrderSystem() {
        currentShake = null;
        orderedShakes = new ArrayList<>();
        director = new Director();
        builder = null;
        openOrder = false;


    }

    public void orderNewShakeMenu() {
        String menu = """


                \t\t   Select your shake   \s

                \t\t Type '1': Chocolate Shake (price 230)\s
                \t\t Type '2': Coffee Shake (price 250)
                \t\t Type '3': Strawberry Shake (price 200)
                \t\t Type '4': Vanilla Shake (price 190)
                \t\t Type '5': Zero Shake (price 240)
                """;
        System.out.println(menu);


    }

    public void customizeShakeMenu() {
        String menu = """


                 Select your customization option for your shake   \s

                \t Type '1': Make lactose free (price increases 60 tk)\s
                \t Type '2': Add Candy (price increases 50 tk)\s
                \t Type '3': Add Cookies (price increases 50 tk)\s
                """;
        System.out.println(menu);
    }

    public void orderNewShake(String input2) {
        switch (input2) {
            case "1" -> {
                builder = new ShakeBuilder();
                director.chocolateShake(builder);
                currentShake = builder.getShake();
                orderedShakes.add(currentShake);
                System.out.println("\t   Chocolate Shake ordered ");
            }
            case "2" -> {
                builder = new ShakeBuilder();
                director.coffeeShake(builder);
                currentShake = builder.getShake();
                orderedShakes.add(currentShake);
                System.out.println("\t    Coffee Shake ordered ");
            }
            case "4" -> {
                builder = new ShakeBuilder();
                director.vanillaShake(builder);
                currentShake = builder.getShake();
                orderedShakes.add(currentShake);
                System.out.println("\t   Vanilla Shake ordered ");
            }
            case "3" -> {
                builder = new ShakeBuilder();
                director.strawberryShake(builder);
                currentShake = builder.getShake();
                orderedShakes.add(currentShake);
                System.out.println("\t   Strawberry Shake ordered ");
            }
            case "5" -> {
                builder = new ShakeBuilder();
                director.zeroShake(builder);
                currentShake = builder.getShake();
                orderedShakes.add(currentShake);
                System.out.println("\t    Zero Shake ordered ");
            }
            default -> System.out.println("\t    Invalid input");
        }

    }


    public void customizeShake(String input2) {
        switch (input2) {
            case "1" -> {
                if (builder.makeLactoseFree()) {
                    currentShake = builder.getShake();
                    orderedShakes.remove(orderedShakes.size() - 1);
                    orderedShakes.add(currentShake);
                    System.out.println("\t Your shake is lactose free");
                } else {
                    System.out.println("\t You have already ordered lactose free shake");
                }
            }
            case "2" -> {
                if (builder.addCandyOnTop()) {
                    currentShake = builder.getShake();
                    orderedShakes.remove(orderedShakes.size() - 1);
                    orderedShakes.add(currentShake);
                    System.out.println("\t Added candy on top of your shake");
                } else {
                    System.out.println("\t You have already ordered this customization");
                }
            }
            case "3" -> {
                if (builder.addCookiesOnTop()) {
                    currentShake = builder.getShake();
                    orderedShakes.remove(orderedShakes.size() - 1);
                    orderedShakes.add(currentShake);
                    System.out.println("\t Added cookies on top of your shake");
                } else {
                    System.out.println("\t You have already ordered this customization");
                }
            }
            default -> System.out.println("\t    Invalid input");
        }

    }


    public void takeOrder() {
        String menu = """
                \t    Welcome to order management system!\s

                \t\t Type 'O': Place a order\s
                \t\t Type 'S': Add a shake\s
                \t\t Type 'C': Customize your shake\s
                \t\t Type 'E': Close current order\s
                 \t\t Type 'Q': Quit\s
                """;
        System.out.println(menu);
        while (true) {
            Scanner scn = new Scanner(System.in);
            System.out.print("\t\tChoose your option : ");
            String input = scn.nextLine();
            switch (input) {
                case "O":
                    if (!openOrder) {
                        openOrder = true;
                        System.out.println("\t\t Order opened");
                    } else {
                        System.out.println("\tYou need to close your current order.\n " +
                                "Do you want to include something else in the current order?");
                    }
                    break;
                case "S":
                    if (!openOrder) {
                        System.out.println("\tYou need to open order first");
                    } else {
                        orderNewShakeMenu();
                        System.out.print("\t\tChoose your option : ");
                        String input2 = scn.nextLine();
                        orderNewShake(input2);
                        System.out.println(menu);

                    }

                    break;
                case "C":
                    if (currentShake == null) {
                        System.out.println("\t You need to select a shake first");
                    } else {
                        customizeShakeMenu();
                        System.out.print("\t\tChoose your option : ");
                        String input2 = scn.nextLine();
                        customizeShake(input2);
                        System.out.println(menu);

                    }
                    break;
                case "E":
                    if (orderedShakes.isEmpty())
                    {
                        System.out.println("You need to order at least one shake");
                    }
                    else
                    {
                        double count=0;
                        for(Shake i:orderedShakes)
                        {
                            System.out.println("---------------------------------");
                            i.show();
                            count+=i.getPrice();

                        }
                        System.out.println("Total order: "+count+"TK");
                        openOrder=false;
                        currentShake = null;
                        orderedShakes = new ArrayList<>();
                        builder = null;

                    }
                    break;
                case "Q":
                    break;
            }
        }
    }


}
