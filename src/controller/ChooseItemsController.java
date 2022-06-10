package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.*;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseItemsController extends Helper {

    @FXML
    VBox type1,type2,type3,list;
    @FXML
    Label priceLabel,type1Label,type2Label,type3Label;

    ArrayList<String>orderList=new ArrayList<>();
    double price;
    public void start(Customer customer, Restaurant restaurant) throws NullPointerException{
        price=customer.getMoney();
        type1Label.setText("Fast Foods");
        type2Label.setText("Iranian Food");
        type3Label.setText("Drinks");
        type1.setSpacing(20);
        type2.setSpacing(20);
        type3.setSpacing(20);
        list.setSpacing(20);
        //show items
        for (int i = 0; i <restaurant.getItemsNumber();i++){
            String[] itemInformation=restaurant.getItems().get(i).split(" ");
            String item = itemInformation[1] +itemInformation[2]+" $";
            Button button=new Button(item);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    price+=Double.parseDouble(itemInformation[2]);
                    showPrice();
                    orderList.add(item);
                    Button button1=new Button(item);
                    list.getChildren().add(button1);
                    //button for remove item
                    button1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            price-=Double.parseDouble(itemInformation[2]);
                            showPrice();
                            orderList.remove(item);
                            list.getChildren().remove(button1);
                        }
                    });
                }
            });
            if(itemInformation[0].equals(RestaurantItems.FAST_FOODS.toString())){
                type1.getChildren().add(button);
            }else if(itemInformation[0].equals(RestaurantItems.IRANIAN_FOODS.toString())){
                type2.getChildren().add(button);
            } else {
                type3.getChildren().add(button);
            }
        }

    }

    public void start(Customer customer, Cafe cafe) throws NullPointerException{
        price=customer.getMoney();
        type1Label.setText("Foods");
        type2Label.setText("Desserts");
        type3Label.setText("Drinks");
        //show items
        for (int i = 0; i <cafe.getItemsNumber();i++){
            String[] itemInformation=cafe.getItems().get(i).split(" ");
            String item = itemInformation[1] +"  "+itemInformation[2]+" $";
            Button button=new Button(item);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    price+=Double.parseDouble(itemInformation[2]);
                    showPrice();
                    orderList.add(item);
                    Button button1=new Button(item);
                    list.getChildren().add(button1);
                    //button for remove item
                    button1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            price-=Double.parseDouble(itemInformation[2]);
                            showPrice();
                            orderList.remove(item);
                            list.getChildren().remove(button1);
                        }
                    });
                }
            });
            if(itemInformation[0].equals(CafeItems.FOODS.toString())){
                type1.getChildren().add(button);
            }else if(itemInformation[0].equals(CafeItems.DESSERTS.toString())){
                type2.getChildren().add(button);
            } else {
                type3.getChildren().add(button);
            }
        }

    }

    public void showPrice(){
        priceLabel.setText(Double.toString(price));
    }

    public void order(ActionEvent event){

    }
    @Override
    public void back(ActionEvent event) throws IOException {

    }
}
