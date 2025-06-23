package Employees;

import java.util.ArrayList;

import Account.Account;
import Bank.Bank;

public class Officer extends  Employee
{
    public Officer(String employeeName) 
    {
        super(employeeName, "Officer");
    }
    @Override
    public String approveLoan()
    {
        //System.out.println("inside officer");
        StringBuffer str=new StringBuffer();
        ArrayList<Account> accountsList = Bank.getInstance().getAccounts();
        for( Account ac : accountsList)
        {
            if(ac.getRequestedLoan()>0.0)
            {
                ac.setTotalLoan(ac.getTotalLoan()+ac.getRequestedLoan());
                ac.setTotalDeposit(ac.getTotalDeposit()+ac.getRequestedLoan());
                ac.setRequestedLoan(0.0);
                str.append("Loan for "+ac.getUsername()+" is approved");
            }            
        }

        if(str.length()>0)
        {
            return str.toString();
        }
        else
        {
            return "No loan request found";
        }

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
