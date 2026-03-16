import java.util.Scanner;

public class BankApp {
    BankService bankService = new BankService();
    Scanner scanner = new Scanner(System.in);

    public void start(){
        setupInitialData();

        boolean isRunning = true;
        System.out.println("Welcome to RomBank App!");
        while(isRunning){
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> showBalance();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> isRunning = false;
                default -> System.out.println("Invalid choice!");
            }
        }
        System.out.println("Thank you for using our app!");
    }

    private void setupInitialData(){
        bankService.addAccount(new SavingsAccount("SV001", "Andrei", 1000.0, 3.5));
        bankService.addAccount(new CheckingAccount("CH001", "Maria", 500.0, 200.0));
    }

    private void printMenu() {
        System.out.println("\n1. Show current Sold | 2. Deposit | 3. Withdraw | 4. Exit");
        System.out.print("Choose an option: ");
    }

    private void showBalance(){
        System.out.println("Type your account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount bankAccount = bankService.getAccount(accountNumber);

        if (bankAccount != null){
            System.out.println("Account owner: " + bankAccount.getAccountNumber());
            System.out.println("Balance: " + bankAccount.getBalance());
        }
        else{
            System.out.println("Account does not exist!");
        }
    }

    private void depositMoney(){
        System.out.println("Type your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Amount to be deposited: ");
        double amount = scanner.nextDouble();

        BankAccount bankAccount = bankService.getAccount(accountNumber);
        if(bankAccount != null){
            bankAccount.deposit(amount);
        }
        else{
            System.out.println("Account does not exist!");
        }
    }

    private void withdrawMoney(){
        System.out.println("Type your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.println("Amount to be withdrawn: ");
        double amount = scanner.nextDouble();

        BankAccount bankAccount = bankService.getAccount(accountNumber);
        if(bankAccount != null){
            bankAccount.withdraw(amount);
        }
        else{
            System.out.println("Account does not exist!");
        }
    }
}
