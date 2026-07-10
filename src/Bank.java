import java.util.Scanner;

public class Bank {
    Scanner scanner = new Scanner(System.in);

    Account[] accounts = new Account[20];
    int accountCount = 0;
    String bankName;

    Bank(String bankName) {
        this.bankName = bankName;
    }

    void openAccount(Scanner scanner) {
        if(accountCount == accounts.length) {
            System.out.println("The account number is full");
        }
        System.out.print("Enter name of the user: ");
        String ownerName = scanner.nextLine();

        String accountNumber = String.format("ACC-%03d", accountCount + 1);

        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter account type: ");
        String accountType = scanner.nextLine();

        if(accountNumber.isEmpty() || ownerName.isEmpty() || accountType.isEmpty() || balance < 0) {
            System.out.println("Invalid input");
            return;
        }
        accounts[accountCount] = new Account(ownerName, accountNumber, balance, accountType);
        accountCount++;

        System.out.println("Account has been created successfully");
        System.out.println("*************************************");
    }

    void showAccounts(Scanner scanner) {
        if(accountCount == 0) {
            System.out.println("The account number is empty");
        } else{
            for(int i = 0; i < accountCount; i++) {
                accounts[i].Showinfo();
            }
        }
    }

    void deposit(Scanner scanner) {

        if(accountCount == 0) {
            System.out.println("The account number is empty");
        }
        for(int i = 0; i < accountCount; i++) {
            System.out.println(i + 1 + " - " + accounts[i].ownerName);
        }
        System.out.print("Choose the person to deposit: ");
        int personNumber = scanner.nextInt();
        scanner.nextLine();

        if(personNumber > accountCount || personNumber < 0) {
            System.out.println("Invalid input");
            return;
        }
        System.out.print("Enter an amount to be deposited: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if(amount <= 0) {
            System.out.println("Amount cannot be negative");
            return;
        }
        accounts[personNumber - 1].balance += amount;
        System.out.println("Deposited " + amount + " | New Balance: " + accounts[personNumber - 1].balance);

    }

    void withdraw(Scanner scanner) {
        if(accountCount == 0) {
            System.out.println("The account number is empty");
        }
    }

    void transfer(Scanner scanner) {
        if(accountCount == 0) {
            System.out.println("The account number is empty");
            return;
        }
        for(int i = 0; i < accountCount; i++) {
            System.out.println(i + 1 + " - " + accounts[i].ownerName + " - " + accounts[i].balance);
        }

        System.out.print("Sender person: ");
        int personNumber = scanner.nextInt();
        scanner.nextLine();

        if(personNumber > accountCount || personNumber < 1) {
            System.out.println("Invalid input");
            return;
        }

        System.out.print("Receiver person: ");
        int receiverIndex = scanner.nextInt();
        scanner.nextLine();

        if(receiverIndex > accountCount || receiverIndex < 1) {
            System.out.println("Invalid input");
            return;
        }
        if(personNumber == receiverIndex) {
            System.out.println("Cannot transfer to the same person");
            return;
        }

        System.out.print("Enter amount to be transferred: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if(amount <= 0) {
            System.out.println("Amount cannot be negative");
            return;
        }

        accounts[personNumber - 1].balance -= amount;
        accounts[receiverIndex - 1].balance += amount;

        System.out.println("Transfer successful");
        System.out.println("Sender new balance: " + accounts[personNumber - 1].balance);
        System.out.println("Receiver new balance: " + accounts[receiverIndex - 1].balance);
    }

    void accountDetails(Scanner scanner)  {
        if(accountCount == 0) {
            System.out.println("The account number is empty");
        }
        System.out.println("=================================");
        System.out.println("Account details");
        System.out.println("=================================");
        for(int i = 0; i < accountCount; i++) {
            System.out.println(i + 1 + " - " + accounts[i].ownerName + " - " + accounts[i].balance);
        }
        System.out.print("Choose the person for details: ");
        int personNumber = scanner.nextInt();
        scanner.nextLine();
        if(personNumber > accountCount || personNumber < 1) {
            System.out.println("Invalid input");
            return;
        }
        System.out.print("===============================");
        accounts[personNumber - 1].AccountOfDetails();
        if(accounts[personNumber - 1].isActive == true) {
            System.out.println("Status: Active");
        }else{
            System.out.println("Status: Inactive");
        }
        System.out.println("Account details successful");
        System.out.print("===============================");
    }

    void closeAccount(Scanner scanner) {
        if(accountCount == 0) {
            System.out.println("No accounts exist.");
            return;
        }

        for(int i = 0; i < accountCount; i++) {
            String status = accounts[i].isActive ? "ACTIVE" : "CLOSED";
            System.out.println((i + 1) + " - " + accounts[i].ownerName + " - " + status);
        }

        System.out.print("Choose account to close: ");
        int personNumber = scanner.nextInt();
        scanner.nextLine();

        if(personNumber < 1 || personNumber > accountCount) {
            System.out.println("Invalid input.");
            return;
        }

        if(!accounts[personNumber - 1].isActive) {
            System.out.println("This account is already closed.");
            return;
        }

        accounts[personNumber - 1].isActive = false;
        System.out.println("Account of " + accounts[personNumber - 1].ownerName + " has been closed.");
    }

    void ActivateAccount(Scanner scanner) {
        System.out.println("***********************");
        System.out.println("Activation of the account details");
        System.out.println("***********************");

        if(accountCount == 0) {
            System.out.println("The account number is empty");
            return;
        }
        for(int i = 0; i < accountCount; i++) {
            System.out.print(i + 1 + " - " + accounts[i].ownerName + " - " + accounts[i].balance);
        }
        System.out.print("Choose the account to be activated: ");
        int activeNumber = scanner.nextInt();
        scanner.nextLine();
        if(activeNumber > accountCount || activeNumber < 1) {
            System.out.println("Invalid input");
            return;
        }
        if(accounts[activeNumber - 1].isActive == true) {
            System.out.println("Status: Active");
        } else{
            accounts[activeNumber - 1].isActive = true;
            System.out.println("The account " + accounts[activeNumber - 1].ownerName + " has been activated");
        }

    }

}
