/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Random;
import java.util.Scanner;

/**
 *
 *
 */
public class BankingApplication1 {

    /**
     * \ the command line arguments
     */
    public static void main(String[] args) {
        int option = 0, number;
        String accountName;
        int accountNumber ;
        double balance, amount,minumum = 1000;
        Bank bank = new Bank();
        Account account;
        Scanner scan = new Scanner(System.in);
        
        while (option != 6){
            System.out.println("Main Menu");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Open New Account");
            System.out.println("3. Close Existing Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.println();
            
            System.out.print("Enter your choice: ");
            option = scan.nextInt();
            scan.nextLine();
        
            switch(option){
                case 1:
                    bank.listAccounts();
                    break;
                case 2:
                    accountNumber = generateAccountNumber();
                    System.out.print("Enter Account Name: ");
                    accountName = scan.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    balance = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Enter account type: S. Savings C. Current");
                    String accountType = scan.nextLine()   ;
                    if (accountType.toLowerCase().equals("S")){
                        account = new SavingAccounts(accountNumber, accountName, balance);
                    } else if (accountType.equals("C")){
                        account = new CurrentAccount(accountNumber, accountName, balance, minumum);
                    } else {
                        System.out.println("Invalid account type");
                    }
                  
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    number = scan.nextInt();
                    scan.nextLine();
                    account = bank.getAccount(number);
                    System.out.println("Enter account type: S. Savings C. Current");
                    accountType = scan.nextLine();

                    if (accountType.toLowerCase().equals("S")){
                        account = bank.getAccount(accountNumber,accountType);

                    } else if (accountType.toLowerCase().equals("C")){
                        account = new CurrentAccount(accountNumber, accountName, balance, minumum);
                    }
                    bank.closeAccount(account);
                    System.out.println("Account Closed");
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
scan.nextLine();
                    System.out.println("Enter account type: S. Savings C. Current");
                    accountType = scan.nextLine();

                    if (accountType.toLowerCase().equals("S")){
                        account = bank.getAccount(accountNumber,"SavingAccounts");

                    } else if (accountType.toLowerCase().equals("C")){
                        account = bank.getAccount(accountNumber, "CurrentAccount");
                    }
                    System.out.print("Enter Amount: ");
                    amount = scan.nextDouble();

                    bank.depositMoney(account, amount);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    number = scan.nextInt();
                    scan.nextLine();
                    accountType = scan.nextLine();

                    if (accountType.toLowerCase().equals("S")){
                        account = bank.getAccount(accountNumber,"SavingAccounts");

                    } else if (accountType.toLowerCase().equals("C")){
                        account = bank.getAccount(accountNumber, "CurrentAccount");
                    }
                    System.out.print("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.withdrawMoney(number, amount);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
            System.out.println();
        }
    }
    
    public static int generateAccountNumber(){
        Random rand = new Random();
        int number = 100000 + rand.nextInt(900000);
        return number;
    }
    
}


