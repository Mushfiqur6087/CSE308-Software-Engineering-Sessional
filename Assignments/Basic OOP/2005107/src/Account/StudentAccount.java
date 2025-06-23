package Account;
import Bank.Bank;
public class StudentAccount extends Account{
    private static double MAX_WITHDRAW = 10000;
    private static double MAX_LOAN = 1000;
    private static double ACCOUNT_INTEREST = 5;
    private static double SERVICE_CHARGE = 0.0;
    public StudentAccount(String username, Double initialDeposit) 
    {
        super(username, "Student", initialDeposit);
    }
    public static void setACCOUNT_INTEREST(double ACCOUNT_INTEREST) 
    {
        StudentAccount.ACCOUNT_INTEREST = ACCOUNT_INTEREST;
    }
    public static double getACCOUNT_INTEREST() {
        return ACCOUNT_INTEREST;
    }
    public static double getServiceCharge() {
        return SERVICE_CHARGE;
    }
    

    @Override
    public String deposit(double amount) 
    {
            setTotalDeposit(getTotalDeposit()+amount);
            Bank bank=Bank.getInstance();
            bank.setInternalFund(bank.getInternalFund()+amount);
            return amount + "$ deposited; current balance " + getTotalDeposit() + "$";
    }

    @Override
    public String withdraw(double amount) 
    {
        if (amount > MAX_WITHDRAW)
        {
            return "Invalid transaction; current balance " + getTotalDeposit() + "$";
        }
        if (getTotalDeposit()-amount < 0)
        {
            return "Invalid transaction; current balance " + getTotalDeposit() + "$";
        }


        Bank bank=Bank.getInstance();
        bank.setInternalFund(bank.getInternalFund()-amount);
        setTotalDeposit(getTotalDeposit()-amount);
        return amount + "$ withdrawn successfully ; current balance " +getTotalDeposit() + "$";
    }

    @Override
    public String requestLoan(double amount) 
    {
        if(getRequestedLoan()!=0.0)
        {
            return "Invalid request !! Your loan request is already in process";
        }
        if (getTotalLoan()+amount > MAX_LOAN)
        {
            return "Invalid request ! Maximum allowable loan for your savings account is " + MAX_LOAN + "$";
        }
            setRequestedLoan(amount);
        return "Loan request successful, sent for approval";
    }






    
}
