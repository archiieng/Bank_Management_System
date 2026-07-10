import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank  bank = new Bank("Archi Bank");
        //bank.run;
        boolean done = true;

        while (done) {
            System.out.println("1. Open new account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Transfer money (account to account)");
            System.out.println("6. Activate account");
            System.out.println("7. Show account details");
            System.out.println("8. Close account");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> bank.openAccount(scanner);
                case 2 -> bank.showAccounts(scanner);
                case 3 -> bank.deposit(scanner);
                case 4 -> bank.withdraw(scanner);
                case 5 -> bank.transfer(scanner);
                case 6 -> bank.ActivateAccount(scanner);
                case 7 -> bank.accountDetails(scanner);
                case 8 -> bank.closeAccount(scanner);

            }
        }


        scanner.close();
    }
}