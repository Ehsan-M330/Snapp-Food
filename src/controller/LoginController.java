package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Files;
import java.io.IOException;
import java.util.ArrayList;


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
            //get information from files
            ArrayList<String>customersInformation;
            customersInformation= Files.readCustomersFile();
            ArrayList<String>deliveriesInformation;
            deliveriesInformation=Files.readDeliveriesFile();

            //check
            for(int i=0;i<customersInformation.size();i++){
                String[] temp=customersInformation.get(i).split(" ");
                if(temp[3].equals(userName.getText()) && temp[4].equals(password.getText())){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("..\\view\\customerPage.fxml"));
                    loader.load();
                    getStage().setScene(new Scene(loader.getRoot()));
                    CustomerPageController customerPageController=loader.getController();
                    customerPageController.setStage(getStage());
                    return;
                }
            }
            for(int i=0;i<deliveriesInformation.size();i++){
                String[] temp=deliveriesInformation.get(i).split(" ");
                if(temp[3].equals(userName.getText()) && temp[4].equals(password.getText())){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("..\\view\\deliveryPage.fxml"));
                    loader.load();
                    getStage().setScene(new Scene(loader.getRoot()));
                    DeliveryPageController deliveryPageController=loader.getController();
                    deliveryPageController.setStage(getStage());
                    return;
                }
            }
            label.setText("Wrong information");

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
