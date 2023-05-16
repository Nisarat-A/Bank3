public class SavingAccounts implements Account{
    private int accountNumber;

    private String accountName;
    private  double balance;
    private String accountType;

    public SavingAccounts(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.accountType = accountType;}

    public String getAccountName(){return this.accountName;}
    public String getName(){return  this.accountName;}

    public double Deposit(double amount){return this.balance+amount;}

    public double Withdraw(double amount){return this.balance-amount;}

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public double getBalance(){return this.balance;}
    @Override
    public String getAccountType(){return this.accountType;}
    @Override
    public int getAccountNumber(){return this.accountNumber;}

}
