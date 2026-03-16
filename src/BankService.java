import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class BankService {
    Map<String, BankAccount> bankAccounts = new HashMap<>();
    private final String FILE = "accounts.txt";

    public void addAccount(BankAccount bankAccount){
        bankAccounts.put(bankAccount.getAccountNumber(), bankAccount);
    }
    public BankAccount getAccount(String accountNumber){
        return bankAccounts.get(accountNumber);
    }

    public void loadAccounts(){
        File file = new File(FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while( (line = reader.readLine()) != null){
                String[] lineSplit = line.split(",");
                if (lineSplit.length < 6)
                    continue;

                String type = lineSplit[0];
                String accountNumber = lineSplit[1];
                String user = lineSplit[2];
                String pin = lineSplit[3];
                double balance = Double.parseDouble(lineSplit[4]);
                double extraParam = Double.parseDouble(lineSplit[5]);

                if(type.equals("SAVINGS")){
                    addAccount(new SavingsAccount(user, accountNumber, pin, balance, extraParam));
                }
                else{
                    addAccount(new CheckingAccount(user, accountNumber, pin, balance, extraParam));
                }
            }
            System.out.println("Accounts loaded successfully!");
        }
        catch(Exception e){
            System.out.println("Error loading accounts.txt file!");
        }
    }

    public void saveAccounts(){
        File file = new File(FILE);
        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
            for (BankAccount bankAccount : bankAccounts.values()) {
                String type = (bankAccount instanceof CheckingAccount) ? "CHECKING" : "SAVINGS";
                double extraParam = (bankAccount instanceof CheckingAccount) ?
                        ((CheckingAccount) bankAccount).getOverdraftLimit() :
                        ((SavingsAccount) bankAccount).getInterestRate();
                out.println(type + "," + bankAccount.getAccountNumber() + "," +
                        bankAccount.getUser() + "," + bankAccount.getPin() + "," +
                        bankAccount.getBalance() + "," + extraParam);
            }
            System.out.println("Saved accounts.txt file!");
        }
        catch(Exception e){
            System.out.println("Error saving accounts.txt file!");
        }
    }

    public void transfer(String sourceNumber, String destinationNumber, double amount){
        BankAccount source = bankAccounts.get(sourceNumber),
                    destination = bankAccounts.get(destinationNumber);

        if(amount <= 0){
            System.out.println("Amount must be greater than 0.");
            return;
        }

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
