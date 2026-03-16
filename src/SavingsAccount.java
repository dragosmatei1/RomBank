public class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(double interestRate){
        super(accountNumber, balance, user);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount){
        if (amount <= getBalance()){
            setBalance(getBalance() - amount);
            System.out.println("Savings account withdrawal successful!");
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
