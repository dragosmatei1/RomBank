import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            File file = new File("src/grafica.fxml");

            if (!file.exists()) {
                System.out.println("EROARE: Fisierul NU a fost gasit la calea specificata!");
                return;
            }

            FXMLLoader loader = new FXMLLoader(file.toURI().toURL());
            Parent root = loader.load();

            primaryStage.setTitle("RomBank");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}