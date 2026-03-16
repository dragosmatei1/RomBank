import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cream serviciul bancar
        List<BankAccount> accounts = new ArrayList<>();

        // Cream un cont de economii si unul curent
        SavingsAccount savings = new SavingsAccount("SV123", "Andrei", 1000.0, 5.0);
        CheckingAccount checking = new CheckingAccount("CH456", "Maria", 200.0, 500.0);

        accounts.add(savings);
        accounts.add(checking);

        System.out.println("--- Testare operatiuni ---");

        // 1. Testare retragere normala din economii
        savings.withdraw(500);

        // 2. Testare aplicare dobanda (specific Savings)
        savings.setInterestRate(1);

        // 3. Testare overdraft pe contul curent
        checking.withdraw(600); // Balanta va deveni -400, e permis (limita e 500)

        System.out.println("\n--- Rezumat final conturi ---");
        for (BankAccount account : accounts) {
            // Aici vedem polimorfismul: Java apeleaza getBalance() din BankAccount
            // dar stim ca obiectele sunt de tipuri diferite
            System.out.println("Titular: " + account.getUser() +
                    " | Sold: " + account.getBalance());
        }
    }
}