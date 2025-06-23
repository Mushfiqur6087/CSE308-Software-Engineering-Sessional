package Employees;

import java.util.ArrayList;

import Account.Account;
import Bank.Bank;

public abstract class Employee 
{
    private String employeeName;
    private String employeeType;
    public String getEmployeeName() {
        return employeeName;
    }
    public String getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Employee(String employeeName, String employeeType) 
    {
        this.employeeName = employeeName;
        this.employeeType = employeeType;
    }
    public String Lookup (String username) 
    {
        ArrayList<Account> accountsList = Bank.getInstance().getAccounts();
        for(Account ac :accountsList)
        {
            if(ac.getUsername().equals(username))
            {
                return ac.getUsername() + "'s current balance " +ac.getTotalDeposit()+"$";
            }
        };
        return "No account found with username "+username;
    }
    public abstract String approveLoan();
    public abstract String changeInterest(String accountType, double newInterest);
    public abstract String seeInternalFund();
}
