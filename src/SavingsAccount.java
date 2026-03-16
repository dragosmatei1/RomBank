public class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String user, String accountNumber, double balance, double interestRate){
        super(accountNumber, balance, user);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount){
        if (amount <= getBalance()){
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            System.out.println("Savings account withdrawal successful!");
            System.out.println("Current balance is: " + newBalance);
        }
        else {
            System.out.println("You don't have sufficient funds!");
        }
    }

    public void setInterestRate(double interestRate){
        double interest = getBalance() *  (interestRate/100);
        deposit(interest);
        System.out.println("Savings account interest rate successful applied!");
    }

}
