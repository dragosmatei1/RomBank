public abstract class BankAccount {
    private String user;
    private double balance;
    private String accountNumber;

    public BankAccount(String user, double balance, String accountNumber) {
        this.user = user;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getUser() {
        return user;
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
            System.out.println("You have deposited $" + amount);
        }
    }
    public abstract void withdraw(double amount);
}
