import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class BankController {

    @FXML
    private Label balanceLabel;

    @FXML
    private TextField accountNumberField;

    @FXML
    private PasswordField pinField;

    @FXML
    private TextField amountField;

    @FXML
    private void handleShowBalance(){
        Integer x;
    }

    @FXML
    private void handleDeposit(){
        String x;
    }

    @FXML
    private void handleWithdraw(){
        Integer x;
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}