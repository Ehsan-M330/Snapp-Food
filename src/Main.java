import controller.FirstPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

import javax.swing.Icon;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view\\firstPage.fxml"));
        try {
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            stage.setTitle("Snapp Food");
            Image icon = new Image("/Icons/Food.png");
            stage.getIcons().add(icon);
            FirstPageController firstPageController=loader.getController();
            firstPageController.setStage(stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
