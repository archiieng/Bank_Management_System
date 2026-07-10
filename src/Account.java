import java.util.Scanner;

public class Account {
    String ownerName;
    String accountNumber;  // e.g. "ACC-001"
    double balance;
    String accountType;    // "savings" or "checking"
    boolean isActive = true;

    Account(String ownerName, String accountNumber, double balance, String accountType) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }
    void Showinfo(){
        System.out.println("Name: " + ownerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Account Type: " + accountType);
        System.out.println("Is Active: " + isActive);
    }
    void AccountOfDetails(){
        System.out.println("Owner: " + ownerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("AccountType: " + accountType);
        System.out.println("Balance: " + balance);
    }
}
