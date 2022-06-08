package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Files;
import model.Information;

import java.awt.Color;
import java.io.IOException;

public class FirstPageController {
    private Stage stage;

    public Stage getStage() {
        return stage;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private Button exitbutton;

    @FXML
    private Button loginbutton;

    @FXML
    private Button registerbutton;

    //Effect effect = loginbutton.getEffect();

    @FXML
    void Style1(MouseEvent event) {
        loginbutton.setCursor(Cursor.HAND);
        //loginbutton.setEffect(null);
        //loginbutton.setStyle("-fx-background-color: #ffffff; ");

    }

    @FXML
    void Style2(MouseEvent event) {
        registerbutton.setCursor(Cursor.HAND);
    }

    @FXML
    void Style3(MouseEvent event) {
        exitbutton.setCursor(Cursor.HAND);
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
