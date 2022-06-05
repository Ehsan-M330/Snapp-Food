package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPageController {
    private Stage stage;

    @FXML
    ImageView image;

    public void setImage(ImageView image) {
        this.image = image;
    }

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
