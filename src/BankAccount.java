import lombok.*;

@Getter @AllArgsConstructor
public abstract class BankAccount {
    private String user;
    private String accountNumber;
    private String pin;

    @Setter(AccessLevel.PROTECTED)
    private double balance;

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
            System.out.println("You have deposited $" + amount);
        }
    }
    public abstract void withdraw(double amount);
}
