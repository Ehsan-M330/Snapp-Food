package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Files;
import model.Information;

import java.io.IOException;

public class FirstPageController {
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void login(ActionEvent event){
        FXMLLoader loader =new FXMLLoader(getClass().getResource("..\\view\\login.fxml"));
        try{
            loader.load();
            getStage().setScene(new Scene(loader.getRoot()));
            LoginController loginController=loader.getController();
            loginController.setStage(getStage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void exit(ActionEvent event) throws IOException {
        //write information in file

        //write customers information
        Files.writeCustomersInFile(Information.getCustomersInformation());

        //write deliveries information
        Files.writeDeliveriesInFile(Information.getDeliveriesInformation());

        //write restaurants information
        Files.writeRestaurantInFile(Information.getRestaurantsInformation());

        //write cafes information
        Files.writeCafeInFile(Information.getCafesInformation());

        //exit
        System.exit(0);
    }

    public void register(ActionEvent event){
        FXMLLoader loader =new FXMLLoader(getClass().getResource("..\\view\\register.fxml"));
        try{
            loader.load();
            getStage().setScene(new Scene(loader.getRoot()));
            RegisterController registerController=loader.getController();
            registerController.setStage(getStage());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
