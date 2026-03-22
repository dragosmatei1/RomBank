import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {
    @FXML private TextField accountNumberField;
    @FXML private PasswordField pinField;
    @FXML private Button loginButton;

    private BankService bankService = new BankService();

    @FXML
    public void initialize() {
        try {
            bankService.loadAccounts();
        } catch (Exception exception) {
            System.out.println("Error: Couldn't load accounts.");
        }
    }

    @FXML
    private void loginButton() {
        String accountNumber = accountNumberField.getText();
        String pin = pinField.getText();

        if (accountNumber.isEmpty() || pin.isEmpty()) {
            showAlert("Error", "Please enter a valid account number and pin.");
            return;
        }

        BankAccount currentAccount = bankService.getAccount(accountNumber);

        if (currentAccount != null && currentAccount.validatePin(pin)) {
            System.out.println("Welcome to " + currentAccount.getUser());
            navigateToDashboard(currentAccount);
        } else {
            showAlert("Error", "Account number or pin is incorrect.");
        }
    }

    private void navigateToDashboard(BankAccount authenticatedAccount) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainMenu.fxml"));
            Parent root = loader.load();

            BankController bankController = loader.getController();
            bankController.initData(authenticatedAccount, bankService);

            Stage stage = (Stage) accountNumberField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("RomBank - Menu");
            stage.show();

        } catch (IOException ioException) {
            System.out.println("Error: Couldn't load main menu.");
            ioException.printStackTrace();
        }
    }

    private void showAlert(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}