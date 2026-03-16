import lombok.*;

@Getter @Setter
public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    CheckingAccount(String user, String accountNumber, String pin, double balance, double overdraftLimit) {
        super(user, accountNumber, pin, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= 0){
            System.out.println("Amount must be greater than 0.");
            return;
        }
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
