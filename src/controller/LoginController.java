package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;


public class LoginController extends Helper {

    @FXML
    TextField userName, password;
    @FXML
    Label label;

    public void login(ActionEvent event) throws IOException {
        //check for admin entry
        if (userName.getText().equals("admin") && password.getText().equals("admin")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\adminPage.fxml"));
            loader.load();
            getStage().setScene(new Scene(loader.getRoot()));
            AdminPageController adminPageController = loader.getController();
            adminPageController.setStage(getStage());
        }else{

        }





    }

    @Override
    public void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\firstPage.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        FirstPageController firstPageController = loader.getController();
        firstPageController.setStage(getStage());

    }
}
