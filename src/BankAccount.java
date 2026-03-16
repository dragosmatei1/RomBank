import lombok.*;

@Getter @AllArgsConstructor
public abstract class BankAccount {
    private String user;
    private String accountNumber;

    @Setter(AccessLevel.PROTECTED)
    private double balance;

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
            System.out.println("You have deposited $" + amount);
        }
    }
    public abstract void withdraw(double amount);
}
