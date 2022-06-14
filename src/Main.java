import controller.FirstPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Files;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) throws IOException {
        //make sure files exists
        FileWriter file1=new FileWriter("customers.txt",true);
        file1.close();
        FileWriter file2 = new FileWriter("restaurants.txt", true);
        file2.close();
        FileWriter file3 = new FileWriter("cafes.txt", true);
        file3.close();
        FileWriter file4 = new FileWriter("deliveries.txt", true);
        file4.close();
        FileWriter file5=new FileWriter("orders.txt",true);
        file5.close();

        //read information from files
        Files.readCustomersFile();
        Files.readDeliveriesFile();
        Files.readRestaurantsFile();
        Files.readCafesFile();
        Files.readOrdersFile();
        launch(args);


    }


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view\\firstPage.fxml"));
        try {
            loader.load();
            stage.setScene(new Scene(loader.getRoot()));
            stage.setTitle("Snapp Food");
            Image icon = new Image("resources/images/snapp-food.png");
            stage.getIcons().add(icon);
            FirstPageController firstPageController=loader.getController();
            firstPageController.setStage(stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
