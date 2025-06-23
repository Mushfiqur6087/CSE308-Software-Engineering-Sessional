package Account;
import Bank.Bank;
public class FixedDepositAccount extends Account
{
    private static double MAX_LOAN = 100000;
    private static double MIN_DEPOSIT = 50000;
    private static double ACCOUNT_INTEREST = 15;
    private static double SERVICE_CHARGE = 500;
    public FixedDepositAccount(String username, Double initialDeposit) 
    {
        super(username, "Fixed Deposit", initialDeposit);
    }
    public static void setACCOUNT_INTEREST(double ACCOUNT_INTEREST) 
    {
       FixedDepositAccount.ACCOUNT_INTEREST = ACCOUNT_INTEREST;
    }
    public static double getMIN_DEPOSIT() {
        return MIN_DEPOSIT;
    }

    public static double getACCOUNT_INTEREST() {
        return ACCOUNT_INTEREST;
    }

    public static double getServiceCharge() {
        return SERVICE_CHARGE;
    }

    public static double setServiceCharge(double SERVICE_CHARGE) 
    {

        FixedDepositAccount.SERVICE_CHARGE = SERVICE_CHARGE;
        return SERVICE_CHARGE;
    }

    

    @Override
    public String deposit(double amount) {
        if (amount >= MIN_DEPOSIT) 
        {
            setTotalDeposit(getTotalDeposit()+amount);
            Bank bank=Bank.getInstance();
            bank.setInternalFund(bank.getInternalFund()+amount);
            return amount + "$ deposited; current balance " + getTotalDeposit() + "$";
        }
        return "Invalid request !! Your deposit amount should not be less than " + MIN_DEPOSIT + "$";
    }
    @Override
    public String withdraw(double amount) 
    {

        if (getYear() < 1)
            return " invalid request !! Your fixed deposit account has not reached maturity period of one year";
        else if (amount > getTotalDeposit())
            return "Invalid transaction; current balance " + getTotalDeposit() + "$";
        Bank bank=Bank.getInstance();
        bank.setInternalFund(bank.getInternalFund()-amount);    
        setTotalDeposit(getTotalDeposit()-amount);
        return amount + "$ withdrawn successfully ; current balance " +getTotalDeposit() + "$";
    }
    @Override
    public String requestLoan(double amount) {
        if(getRequestedLoan()!=0.0)
        {
            return "Invalid request !! Your loan request is already in process";
        }
        if (getTotalLoan()+amount > MAX_LOAN)
            return "Invalid request ! Maximum allowable loan for your fixed deposit account is " + MAX_LOAN + "$";
            setRequestedLoan(amount);
        return "Loan request successful, sent for approval";
    }




    
}
