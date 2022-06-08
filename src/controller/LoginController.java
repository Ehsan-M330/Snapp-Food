package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.Customer;
import model.Delivery;
import model.Information;
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
            //get information
            ArrayList<Customer>customers= Information.getCustomersInformation();
            ArrayList<Delivery>deliveries= Information.getDeliveriesInformation();

            //check
            for(int i=0;i<customers.size();i++){
                if(customers.get(i).getEmail().equals(userName.getText()) && customers.get(i).getPassword().equals(password.getText())){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("..\\view\\customerPage.fxml"));
                    loader.load();
                    getStage().setScene(new Scene(loader.getRoot()));
                    CustomerPageController customerPageController=loader.getController();
                    customerPageController.setStage(getStage());
                    customerPageController.setCustomer(customers.get(i));
                    customerPageController.start();
                    return;
                }
            }
            for(int i=0;i<deliveries.size();i++){
                if(deliveries.get(i).getEmail().equals(userName.getText()) && deliveries.get(i).getPassword().equals(password.getText())){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("..\\view\\deliveryPage.fxml"));
                    loader.load();
                    getStage().setScene(new Scene(loader.getRoot()));
                    DeliveryPageController deliveryPageController=loader.getController();
                    deliveryPageController.setStage(getStage());
                    // TODO: 6/6/2022 add delivery page
                    return;
                }
            }
            label.setText("Wrong information");
            label.setTextFill(Color.RED);
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
