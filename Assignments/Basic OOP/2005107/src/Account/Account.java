package Account;


abstract public class Account 
{
    private String username;
    private String accountType;
    private double initialDeposit;
    private double totalDeposit;
    private double totalLoan;
    private double requestedLoan;
    private int year;
    private static double LOAN_INTEREST = 10;
    public Account(String username, String accountType, double initialDeposit) 
    {
        this.username = username;
        this.accountType = accountType;
        this.initialDeposit = initialDeposit;
        totalLoan=0.0;
        totalDeposit=initialDeposit;
        requestedLoan=0.0;
        year=0;
    }

    private double getLoanInterest()
    {
        return LOAN_INTEREST;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }

    public void setRequestedLoan(double requestedLoan) {
        this.requestedLoan = requestedLoan;
    }

    public double getRequestedLoan() {
        return requestedLoan;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    
    public void setInitialDeposit(double initialDeposit) 
    {
        this.initialDeposit = initialDeposit;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }
    public double getTotalDeposit() {
        return totalDeposit;
    }
    public void setTotalDeposit(double totalDeposit) {
        this.totalDeposit = totalDeposit;
    }
    
    public String getAccountType() {
        return accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String queryDeposit() {
        String string = "Current balance " + getTotalDeposit() + "$";
        if ( getTotalLoan() > 0.0)
            string += ", loan " + getTotalLoan() + "$ . ";
        return string;
    }

    public double addBalance(double amount)
    {
        setTotalDeposit(getTotalDeposit()+amount);
        return getTotalDeposit();
    }

    public double deductBalance(double amount)
    {
        setTotalDeposit(getTotalDeposit()-amount);
        return getTotalDeposit();
    }

    //for loan interest deduction after one year

    public double yearlyLoanDeduction()
    {
        double loanDeduction = getTotalLoan() * getLoanInterest() / 100;
        return loanDeduction;
    }

    //for service charge deduction after one year
    public void serviceChargeDeduction(double amount)
    {
        deductBalance(amount);
    }

    //interest in accounts after one year
    public double interestOnDeposit(double amount)
    {
        double addedBalance=getTotalDeposit() * amount / 100;
        addBalance(addedBalance);
        return addedBalance;
    }

    abstract public String deposit(double depositAmount);
    abstract public String withdraw(double withdrawAmount);
    abstract public String requestLoan(double loadAmount);
    
}
