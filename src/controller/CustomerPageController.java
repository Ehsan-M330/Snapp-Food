package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Cafe;
import model.Customer;
import model.Files;
import model.Restaurant;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerPageController extends Helper {
    Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    ArrayList<Restaurant>restaurants=new ArrayList<>();
    ArrayList<Cafe>cafes=new ArrayList<>();
    public void start() throws IOException {
        setMoneyLabel();
        //read restaurants and cafes from file
        ArrayList<String>restaurantFileInformation;
        restaurantFileInformation=Files.readRestaurantsFile();
        for(int i=0;i<restaurantFileInformation.size();i++){
            String[] temp=restaurantFileInformation.get(i).split(" ");
            //temp[0] == restaurant name
            //temp[1] == restaurant location
            //temp[2] == restaurant items number
            Restaurant restaurant=new Restaurant();
            restaurant.setName(temp[0]);
            restaurant.setLocation(temp[1]);
            ArrayList<String>restaurantItems=new ArrayList<>();
            i++;
            for(int t=0;t<Integer.parseInt(temp[2]);t++,i++){
                restaurantItems.add(restaurantFileInformation.get(i));
            }
            restaurant.setItems(restaurantItems);
            restaurants.add(restaurant);

            if(i==restaurantFileInformation.size()){
                break;
            }else{
                i--;
            }
        }

        ArrayList<String>cafeFileInformation;
        cafeFileInformation=Files.readCafesFile();
        for(int i=0;i<cafeFileInformation.size();i++){
            String[] temp=cafeFileInformation.get(i).split(" ");
            //temp[0] == cafe name
            //temp[1] == cafe location
            //temp[2] == cafe items number
            Cafe cafe=new Cafe();
            cafe.setName(temp[0]);
            cafe.setLocation(temp[1]);
            ArrayList<String>cafeItems=new ArrayList<>();
            i++;
            for(int t=0;t<Integer.parseInt(temp[2]);t++,i++){
                cafeItems.add(cafeFileInformation.get(i));
            }
            cafe.setItems(cafeItems);
            cafes.add(cafe);
            if(i==cafeFileInformation.size()){
                break;
            }else{
                i--;
            }

        }


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
