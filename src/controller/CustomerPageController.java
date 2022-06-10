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
import javafx.scene.paint.Color;
import model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CustomerPageController extends Helper {
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //get restaurants and cafes information
    private ArrayList<Restaurant>restaurants=Information.getRestaurantsInformation();
    private ArrayList<Cafe>cafes=Information.getCafesInformation();
    public void start() throws IOException {
        setMoneyLabel();
    }
    @FXML
    TextField locationTextField;
    @FXML
    Label locationLabel;
    @FXML
    VBox restaurantVbox,cafeVbox;
    @FXML
    Label moneyLabel,moneyMessageLabel;
    @FXML
    TextField moneyTextField;
    public void search(ActionEvent event){
        restaurantVbox.getChildren().removeAll(restaurantVbox.getChildren());
        cafeVbox.getChildren().removeAll(cafeVbox.getChildren());
        for(int i=0;i<restaurants.size();i++){
            if(locationTextField.getText().equals(restaurants.get(i).getLocation())){
                Button button=new Button(restaurants.get(i).getName());
                restaurantVbox.getChildren().add(button);
                restaurantVbox.setSpacing(10);
                Restaurant restaurant=restaurants.get(i);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                         FXMLLoader loader=new FXMLLoader(getClass().getResource("..\\view\\chooseItems.fxml"));
                         try{
                             loader.load();
                             getStage().setScene(new Scene(loader.getRoot()));
                             ChooseItemsController chooseItemsController=loader.getController();
                             chooseItemsController.setStage(getStage());
                             chooseItemsController.start(customer,restaurant);
                         }catch (IOException e){
                             e.printStackTrace();
                         }


                    }
                });
            }
        }
        for(int i=0;i<cafes.size();i++){
            if(locationTextField.getText().equals(cafes.get(i).getLocation())){
                Button button=new Button(cafes.get(i).getName());
                cafeVbox.getChildren().add(button);
                cafeVbox.setSpacing(10);
                Cafe cafe=cafes.get(i);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FXMLLoader loader=new FXMLLoader(getClass().getResource("..\\view\\chooseItems.fxml"));
                        try{
                            loader.load();
                            getStage().setScene(new Scene(loader.getRoot()));
                            ChooseItemsController chooseItemsController=loader.getController();
                            chooseItemsController.setStage(getStage());
                            chooseItemsController.start(customer,cafe);
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }


    public void charge(ActionEvent event){
        if(chargeRegex(moneyTextField.getText())){
            customer.setMoney(customer.getMoney()+Double.parseDouble(moneyTextField.getText()));
            setMoneyLabel();
            moneyTextField.setText("");
            moneyMessageLabel.setText("Added");
            moneyMessageLabel.setTextFill(Color.GREEN);
        }else{
            moneyMessageLabel.setText("Use correct format");
            moneyMessageLabel.setTextFill(Color.RED);
        }
    }

    public boolean chargeRegex(String str){
        return Pattern.matches("[0-9]{1,3}(\\.[0-9]{1,2})?",str);
    }
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
