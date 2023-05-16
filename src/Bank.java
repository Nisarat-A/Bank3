import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bank {
    private String name;

    public Bank(){
    }
    public Bank(String name){
        this.name = name;
    }

    public void listAccounts(){
        Connection connection = BankConnection.connect();
        Statement statement;
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM account";
            ResultSet results = statement.executeQuery(sql);

            while (results.next()){
                System.out.println(results.getString(1)+" "+results.getString(2)+" "+
                        results.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openAccount(Account account){
        Connection connection = BankConnection.connect();
        String sql = "INSERT INTO account (accNumber,accName,accBalance) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, account.getName());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setString(4, account.getAccountType());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeAccount(Account account){
        Connection connection = BankConnection.connect();
        String sql = "DELETE FROM account WHERE accNumber=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountType());

            preparedStatement.executeUpdate();
        //
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void depositMoney(int number, double amount){
        Account account = getAccount(number);
        account.deposit(amount);
        Connection connection = BankConnection.connect();
        String sql = "UPDATE account SET accBalance=? WHERE accNumber=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void withdrawMoney(int number, double amount){
        Account account = getAccount(number);
        account.withdraw(amount);
        Connection connection = BankConnection.connect();
        String sql = "UPDATE account SET accBalance=? WHERE accNumber=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setInt(2, account.getAccountNumber());
            preparedStatement.executeUpdate();
            System.out.println("Balance: " + account.getBalance());
        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAccount(int number){
        Connection connection = BankConnection.connect();
        String sql = "SELECT * FROM account WHERE accID=? and accType=?";
        PreparedStatement preparedStatement;
        Account account = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, AccountNumber);
            preparedStatement.setString(2, AccountType);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            String accountName = result.getString(2);
            double balance = result.getDouble(3);

            if (accountType.equals("SavingsAccounts")){
                account = new SavingsAccount(accountNumber, accountName, balance);
            } else if (acc) {
                
            }
            account = new Account() {
                @Override
                public void deposit(double amount) {

                }

                @Override
                public void withdraw(double amount) {

                }

                @Override
                public double getBalance() {
                    return 0;
                }

                @Override
                public String getAccountType() {
                    return null;
                }

                @Override
                public int getAccountNumber() {
                    return 0;
                }

                @Override
                public String getAccountName() {
                    return null;
                }

                @Override
                public String getName() {
                    return null;
                }
            };

        } catch (SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }

        return account;
    }}