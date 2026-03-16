public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    CheckingAccount(String user, String accountNumber, double balance, double overdraftLimit) {
        super(user, balance, accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(amount < getBalance() + overdraftLimit) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            System.out.println("Withdrawing successful!");
            System.out.println("Current balance is: " + newBalance);
        }
        else{
            System.out.println("Insufficient funds!");
        }
    }
}
