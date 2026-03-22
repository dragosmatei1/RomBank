import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginMenu.fxml"));
            LoginController loginController = new LoginController();

            loader.setController(loginController);

            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setTitle("RomBank - Login");
            primaryStage.setScene(scene);

            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException ioException) {
            System.out.println("Error: Couldn't load loginMenu.fxml.");
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}