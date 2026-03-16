import java.util.Map;
import java.util.HashMap;

public class BankService {
    Map<String, BankAccount> bankAccounts = new HashMap<>();

    public void addAccount(BankAccount bankAccount){
        bankAccounts.put(bankAccount.getAccountNumber(), bankAccount);
    }
    public BankAccount getAccount(String accountNumber){
        return bankAccounts.get(accountNumber);
    }

    public void transfer(String sourceNumber, String destinationNumber, double amount){
        BankAccount source = bankAccounts.get(sourceNumber),
                    destination = bankAccounts.get(destinationNumber);

        if(source != null && destination != null){
            source.withdraw(amount);
            destination.deposit(amount);
            System.out.println("Transfer successful!");
        }
        else{
            System.out.println("Error: One account does not exist");
        }
    }
}
