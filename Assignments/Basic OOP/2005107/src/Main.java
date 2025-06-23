import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Bank.Bank;

public class Main {
    public static final String FILE_NAME = "input.txt";

    public static void main(String[] args) throws IOException {
        Bank bank = Bank.getInstance();
        System.out.println(bank.createBankMember());
        BufferedReader fileReader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] str = line.split(" ");
            switch (str[0].toLowerCase()) {
                case "create":

                    String str2 = bank.createBankAccount(str[1], str[2], Double.parseDouble(str[3]));
                    System.out.println(str2);
                    break;

                case "deposit":
                    Double amount = Double.parseDouble(str[1]);
                    String str3 = bank.getCurrentAccount().deposit(amount);
                    System.out.println(str3);
                    break;

                case "withdraw":
                    Double amount2 = Double.parseDouble(str[1]);
                    String str4 = bank.getCurrentAccount().withdraw(amount2);
                    System.out.println(str4);
                    break;

                case "query":
                    System.out.println(bank.getCurrentAccount().queryDeposit());
                    break;

                case "request":
                    System.out.println(bank.getCurrentAccount().requestLoan((Double.parseDouble(str[1]))));
                    break;

                case "close":
                    System.out.println(bank.logout());
                    break;

                case "open":
                    if (bank.findEmployee(str[1]))
                    {
                      //System.out.println(str[1]);
                        System.out.println(bank.openEmployeeAccount(str[1]));
                    }
                    else if (bank.findBankAccount(str[1]))
                    {
                        System.out.println(bank.openBankAccount(str[1]));
                    }
                    else
                        System.out.println("invalid request !! " + str[1] + " does not exist");
                    break;
                
                case "approve":
                       System.out.println(bank.getCurrentEmployee().approveLoan());
                    break;  
                
                case "change":
                    System.out.println(bank.getCurrentEmployee().changeInterest(str[1],Double.parseDouble(str[2])));
                    break;
                
                case "lookup":
                    System.out.println(bank.getCurrentEmployee().Lookup(str[1]));
                    break;
                
                case "see":
                    System.out.println(bank.getCurrentEmployee().seeInternalFund());
                    break; 
                case "inc":
                    System.out.println(bank.increaseYear());
                    break;       

            }

        }
        fileReader.close();

    }

}
