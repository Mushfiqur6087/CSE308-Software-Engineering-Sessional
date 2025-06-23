package Employees;

import java.util.ArrayList;

import Account.Account;
import Account.FixedDepositAccount;
import Account.SavingsAccount;
import Account.StudentAccount;
import Bank.Bank;

public class ManagingDirector extends Employee{

    public ManagingDirector(String employeeName) 
    {
        super(employeeName, "Managing Director");
    }
    @Override
    public String approveLoan()
    {
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
        if(accountType.equalsIgnoreCase("Savings"))
        {
            SavingsAccount.setACCOUNT_INTEREST(newInterest);
            return "Interest rate for saving account is changed to "+newInterest;
        }
        else if(accountType.equalsIgnoreCase("Student"))
        {
            StudentAccount.setACCOUNT_INTEREST(newInterest);
            return "Interest rate for student account is changed to "+newInterest;
        }
        else if(accountType.equalsIgnoreCase("Fixed Deposit"))
        {
            FixedDepositAccount.setACCOUNT_INTEREST(newInterest);
            return "Interest rate for fixed deposit account is changed to "+newInterest;
        }
        else
        {
            return "Invalid account type";
        }
    }
    @Override
    public String seeInternalFund() 
    {
        return Bank.getInstance().getInternalFund()+"$";
    }


    
}