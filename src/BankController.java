import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BankController {
    @FXML private Label balanceLabel;
    @FXML private TextField amountField;

    private BankAccount currentAccount;
    private BankService bankService;

    public void initData(BankAccount account, BankService service) {
        this.currentAccount = account;
        this.bankService = service;
        updateBalanceLabel();
    }

    @FXML
    private void handleShowBalance() {
        updateBalanceLabel();
    }

    @FXML
    private void handleDeposit() {
        double amount = Double.parseDouble(amountField.getText());
        if (amount > 0) {
            currentAccount.deposit(amount);
            updateBalanceLabel();
            amountField.clear();
        } else {
            showInformation("Error", "The number must be greater than 0.");
        }
    }

    @FXML
    private void handleWithdraw() {
        double amount = Double.parseDouble(amountField.getText());
        if (amount > 0) {
            currentAccount.withdraw(amount);
            updateBalanceLabel();
            amountField.clear();
        } else {
            showInformation("Error", "The number must be greater than 0.");
        }
    }

    @FXML
    private void handleExit() {
        if (bankService != null) {
            bankService.saveAccounts();
        }
        System.exit(0);
    }

    private void updateBalanceLabel() {
        if (currentAccount != null) {
            balanceLabel.setText("Current: $" + currentAccount.getBalance());
        }
    }

    private void showInformation(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}