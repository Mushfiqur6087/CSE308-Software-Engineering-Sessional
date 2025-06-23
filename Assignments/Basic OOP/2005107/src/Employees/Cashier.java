package Employees;
public class Cashier extends Employee{
    public Cashier(String employeeName) {
        super(employeeName, "Cashier");
    }

    @Override
    public String approveLoan() 
    {
        return "You don't have permission for this operation";
    }
    @Override
    public String changeInterest(String accountType, double newInterest) 
    {
        return "You don't have permission for this operation";
    }
    @Override
    public String seeInternalFund() 
    {
        return "You don't have permission for this operation";
    }

    
}
