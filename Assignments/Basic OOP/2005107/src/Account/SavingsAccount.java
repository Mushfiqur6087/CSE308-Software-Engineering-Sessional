package Account;
import Bank.Bank;
public class SavingsAccount extends Account {
    private static double MAX_LOAN = 10000;
    private static double MIN_DEPOSIT = 1000;
    private static double ACCOUNT_INTEREST = 10;
    private static double SERVICE_CHARGE = 500;
    public SavingsAccount(String username, Double initialDeposit) 
    {
        super(username, "Savings", initialDeposit);
    }

    public static void setACCOUNT_INTEREST(double ACCOUNT_INTEREST) 
    {
        SavingsAccount.ACCOUNT_INTEREST = ACCOUNT_INTEREST;
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
        if (getTotalDeposit()-amount < MIN_DEPOSIT)
            return "Invalid transaction; current balance " + getTotalDeposit() + "$";
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
