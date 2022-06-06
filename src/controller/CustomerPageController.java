package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.*;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerPageController extends Helper {
    Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //get restaurants and cafes information
    ArrayList<Restaurant>restaurants=Information.getRestaurantsInformation();
    ArrayList<Cafe>cafes=Information.getCafesInformation();
    public void start() throws IOException {
        setMoneyLabel();
    }
    @FXML
    TextField locationTextField;
    @FXML
    Label locationLabel;
    @FXML
    VBox restaurantVbox,cafeVbox;
    public void search(ActionEvent event){
        restaurantVbox.getChildren().removeAll(restaurantVbox.getChildren());
        cafeVbox.getChildren().removeAll(cafeVbox.getChildren());
        for(int i=0;i<restaurants.size();i++){
            if(locationTextField.getText().equals(restaurants.get(i).getLocation())){
                Button button=new Button(restaurants.get(i).getName());
                restaurantVbox.getChildren().add(button);
                restaurantVbox.setSpacing(10);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // TODO: 6/5/2022
                    }
                });
            }
        }
        for(int i=0;i<cafes.size();i++){
            if(locationTextField.getText().equals(cafes.get(i).getLocation())){
                Button button=new Button(cafes.get(i).getName());
                cafeVbox.getChildren().add(button);
                cafeVbox.setSpacing(10);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // TODO: 6/5/2022
                    }
                });
            }
        }
    }

    @FXML
    Label moneyLabel;

    public void setMoneyLabel(){
        moneyLabel.setText(Double.toString(customer.getMoney()));
    }


    public void sendInvite(ActionEvent event){

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
