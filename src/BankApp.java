import java.util.Scanner;

public class BankApp {
    private BankService bankService = new BankService();
    private Scanner scanner = new Scanner(System.in);
    private BankAccount currentAccount = null;

    public void start(){
        boolean isRunning = true;
        System.out.println("Welcome to RomBank App!");
        bankService.loadAccounts();

        while(currentAccount == null){
            login();
        }

        while(isRunning){
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> showBalance();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> {
                    bankService.saveAccounts();
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
        System.out.println("Thank you for using our app!");
    }

    private void login() {
        System.out.println("Please enter your account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount currentAcc = bankService.getAccount(accountNumber);

        if (currentAcc != null) {
            System.out.print("Introduce your PIN: ");
            String pin = scanner.nextLine();
            if (currentAcc.validatePin(pin)) {
                currentAccount = currentAcc;
                System.out.println("You have successfully logged in!");
            } else {
                System.out.println("Incorrect PIN!");
            }
        } else {
            System.out.println("Account number not found!");
        }
    }

    private void printMenu() {
        System.out.println("\n1. Show current Sold | 2. Deposit | 3. Withdraw | 4. Exit");
        System.out.print("Choose an option: ");
    }

    private void showBalance(){
        if (currentAccount != null){
            System.out.println("Account owner: " + currentAccount.getAccountNumber());
            System.out.println("Balance: $" + currentAccount.getBalance());
        }
        else{
            System.out.println("Unknown error!");
        }
    }

    private void depositMoney(){
        System.out.println("Amount to be deposited: ");
        double amount = scanner.nextDouble();

        if(amount <= 0){
            System.out.println("Amount must be greater than 0.");
            return;
        }

        if(currentAccount != null){
            currentAccount.deposit(amount);
        }
        else{
            System.out.println("Unknown error!");
        }
    }

    private void withdrawMoney(){
        System.out.println("Amount to be withdrawn: ");
        double amount = scanner.nextDouble();

        if(amount <= 0){
            System.out.println("Amount must be greater than 0.");
            return;
        }

        if(currentAccount != null){
            currentAccount.withdraw(amount);
        }
        else{
            System.out.println("Unkown error!");
        }
    }
}
