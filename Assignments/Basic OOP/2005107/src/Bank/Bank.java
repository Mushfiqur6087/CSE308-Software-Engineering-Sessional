package Bank;

import java.util.ArrayList;

import Account.Account;
import Account.FixedDepositAccount;
import Account.SavingsAccount;
import Account.StudentAccount;
import Employees.Cashier;
import Employees.Employee;
import Employees.ManagingDirector;
import Employees.Officer;

public class Bank {
    private static final Bank bank = new Bank();
    ArrayList<Account> accounts;
    ArrayList<Employee> employees;
    Account currentAccount;
    Employee currentEmployee;
    final double INITIAL_FUND = 1000000;
    private double internalFund;

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public Employee getCurrentEmployee() {
       // System.out.println("inside current Employee");
       // System.out.println(currentEmployee.getEmployeeName());
        return currentEmployee;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public boolean isloggedIn() {
        if (currentAccount != null || currentEmployee != null)
            return true;
        return false;

    }

    public boolean isEmployeeLoggedIn() {
        if (currentEmployee != null)
            return true;
        return false;

    }

    public boolean isAccountLoggedIn() {
        if (currentAccount != null)
            return true;
        return false;

    }

    public String logout() {
        String str = "";
      //  System.out.println("inside logout");
       // System.out.println(isEmployeeLoggedIn() + " " + isAccountLoggedIn());
        if (currentEmployee != null) {
            str += "Operations for " + currentEmployee.getEmployeeName()+" closed";
            currentEmployee = null;
            return str;
        } else if (currentAccount != null) {
            str += "Transaction Closed for " + currentAccount.getUsername();
            currentAccount = null;
            return str;
        }
        return "Invalid request !! You are not logged in";
    }

    public boolean isLoanPending() {
        int count = 0;
        for (Account account : accounts) {
            if (account.getRequestedLoan() > 0) {
                count++;
            }
        }
        if (count > 0)
            return true;
        return false;

    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static Bank getInstance() {
        return bank;
    }

    Bank() {
        accounts = new ArrayList<Account>();
        employees = new ArrayList<Employee>();
        internalFund = INITIAL_FUND;
        currentAccount = null;
        currentEmployee = null;
    }

    public double getInternalFund() {
        return internalFund;
    }

    public void setInternalFund(double internalFund) {
        this.internalFund = internalFund;
    }

    public String createBankMember() {
        ManagingDirector MD = new ManagingDirector("MD");
        Officer O1 = new Officer("O1");
        Officer O2 = new Officer("O2");
        Cashier C1 = new Cashier("C1");
        Cashier C2 = new Cashier("C2");
        Cashier C3 = new Cashier("C3");
        Cashier C4 = new Cashier("C4");
        Cashier C5 = new Cashier("C5");
        employees.add(MD);
        employees.add(O1);
        employees.add(O2);
        employees.add(C1);
        employees.add(C2);
        employees.add(C3);
        employees.add(C4);
        employees.add(C5);
        return "Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created";
    }

    public void loanDeduction(Account ac) {
        ac.setYear(ac.getYear() + 1);
        // loan interest deduction after one year
        if (ac.getTotalLoan() > 0.0) {
            double loanDeduction = ac.yearlyLoanDeduction();
            ac.deductBalance(loanDeduction);
            // change internal fund of the bank
            internalFund += loanDeduction;
        }

    }

    public void interestOnDeposit(Account ac) {
        if (ac.getAccountType().equalsIgnoreCase("Fixed Deposit")) {
            double addedBalance = ac.interestOnDeposit(FixedDepositAccount.getACCOUNT_INTEREST());
            internalFund -= addedBalance;

        } else if (ac.getAccountType().equalsIgnoreCase("Savings")) {
            double addedBalance = ac.interestOnDeposit(SavingsAccount.getACCOUNT_INTEREST());
            internalFund -= addedBalance;

        } else if (ac.getAccountType().equalsIgnoreCase("Student")) {
            System.out.println("account flag "+ StudentAccount.getACCOUNT_INTEREST());
            double addedBalance = ac.interestOnDeposit(StudentAccount.getACCOUNT_INTEREST());
            internalFund -= addedBalance;

        }

    }

    public void serviceCharge(Account ac) {
        if (ac.getAccountType().equalsIgnoreCase("Fixed Deposit")) {
            ac.serviceChargeDeduction(FixedDepositAccount.getServiceCharge());
            internalFund += FixedDepositAccount.getServiceCharge();

        } else if (ac.getAccountType().equalsIgnoreCase("Savings")) {
            ac.serviceChargeDeduction(SavingsAccount.getServiceCharge());
            internalFund += FixedDepositAccount.getServiceCharge();

        } else if (ac.getAccountType().equalsIgnoreCase("Student")) {
            ac.serviceChargeDeduction(StudentAccount.getServiceCharge());
            internalFund += FixedDepositAccount.getServiceCharge();

        }

    }

    public String increaseYear() {
        for (Account ac : accounts) {
            loanDeduction(ac);
            interestOnDeposit(ac);
            serviceCharge(ac);
        }
        return "1 year passed";
    }

    public boolean findBankAccount(String name) {
        for (Account account : accounts) {
            if (account.getUsername().equalsIgnoreCase(name)) {
                //currentAccount = account;
                return true;
            }
        }
        return false;
    }

    public boolean findEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getEmployeeName().equalsIgnoreCase(name)) {
                //currentEmployee = employee;
                return true;
            }
        }
        return false;
    }

    public void setCurrentAccount (String name) {
        for (Account account : accounts) {
            if (account.getUsername().equalsIgnoreCase(name)) {
                currentAccount = account;
            }
        }
    }

    public void setCurrentEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getEmployeeName().equalsIgnoreCase(name)) {
                currentEmployee = employee;
            }
        }
    }

    public String createBankAccount(String name, String type, double amount) {
        if (findBankAccount(name))
            return "Account Already Exists!";

        else if (currentAccount != null)
            return "Close " + currentAccount.getUsername() + "first!";

        else if (type.equalsIgnoreCase("student")) {
            currentAccount = new StudentAccount(name, amount);
            accounts.add(currentAccount);

        } else if (type.equalsIgnoreCase("savings")) {
            currentAccount = new SavingsAccount(name, amount);
            accounts.add(currentAccount);
        } else if (type.equalsIgnoreCase("fixed deposit")) {
            if (amount < FixedDepositAccount.getMIN_DEPOSIT())
                return " First deposit for fixed deposit account must be greater than "
                        + FixedDepositAccount.getMIN_DEPOSIT() + "$";
            currentAccount = new FixedDepositAccount(name, amount);
            accounts.add(currentAccount);
        } else {
            return "Invalid type of Account!";
        }
        return type + " account for " + name + " created; initial balance " + amount + "$";
    }

    public String openEmployeeAccount(String name) {
      //  System.out.println("inside flag 1");
        //System.out.println(isEmployeeLoggedIn());
        if (isEmployeeLoggedIn()) 
        {
            return "Close " + currentEmployee.getEmployeeName() + " first";
        }
        if (isAccountLoggedIn()) {
            return "Close " + currentAccount.getUsername() + " first";
        }
        if (findEmployee(name)) {
            setCurrentEmployee(name);
            String string = name + " active";
            if (isLoanPending()) {
                string += ", there are loan approvals pending";
                return string;
            } else {
                string += ", there are no loan approvals pending";
                return string;
            }

        }
        return "Invalid Employee Name !! ";
    }

    public String openBankAccount(String name) {
        if (isAccountLoggedIn()) {
            return "Close " + currentAccount.getUsername() + " first";
        }
        if (isEmployeeLoggedIn()) {
            return "Close " + currentEmployee.getEmployeeName() + " first";
        } else if (findBankAccount(name)) {
            setCurrentAccount(name);
            return "Welcome Back, " + name;
        } else {
            return " Invalid account name !! ";
        }
    }

}
