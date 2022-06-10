package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.*;

import java.io.IOException;
import java.util.ArrayList;

public class ChooseItemsController extends Helper {

    @FXML
    VBox type1, type2, type3, list;
    @FXML
    Label totalPriceLabel, type1Label, type2Label, type3Label, orderLabel;

    ArrayList<String> orderList = new ArrayList<>();
    double totalPrice = 0;
    Customer customer;
    String placeName;

    public void start(Customer customer, Restaurant restaurant) throws NullPointerException {
        this.customer = customer;
        placeName = restaurant.getName();
        type1Label.setText("Fast Foods");
        type2Label.setText("Iranian Food");
        type3Label.setText("Drinks");
        showPrice();
        //show items
        for (int i = 0; i < restaurant.getItemsNumber(); i++) {
            String[] itemInformation = restaurant.getItems().get(i).split(" ");
            String item = itemInformation[1] + "  " + itemInformation[2] + " $";
            Button button = new Button(item);
            button.setFont(Font.font(15));
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    totalPrice += Double.parseDouble(itemInformation[2]);
                    showPrice();
                    orderList.add(item);
                    Button button1 = new Button(item);
                    list.getChildren().add(button1);
                    //button for remove item
                    button1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            totalPrice -= Double.parseDouble(itemInformation[2]);
                            showPrice();
                            orderList.remove(item);
                            list.getChildren().remove(button1);
                        }
                    });
                }
            });
            if (itemInformation[0].equals(RestaurantItems.FAST_FOODS.toString())) {
                type1.getChildren().add(button);
            } else if (itemInformation[0].equals(RestaurantItems.IRANIAN_FOODS.toString())) {
                type2.getChildren().add(button);
            } else {
                type3.getChildren().add(button);
            }
        }

    }

    public void start(Customer customer, Cafe cafe) throws NullPointerException {
        this.customer = customer;
        placeName = cafe.getName();
        totalPrice = customer.getMoney();
        type1Label.setText("Foods");
        type2Label.setText("Desserts");
        type3Label.setText("Drinks");
        showPrice();
        //show items
        for (int i = 0; i < cafe.getItemsNumber(); i++) {
            String[] itemInformation = cafe.getItems().get(i).split(" ");
            String item = itemInformation[1] + "  " + itemInformation[2] + " $";
            Button button = new Button(item);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    totalPrice += Double.parseDouble(itemInformation[2]);
                    showPrice();
                    orderList.add(item);
                    Button button1 = new Button(item);
                    list.getChildren().add(button1);
                    //button for remove item
                    button1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            totalPrice -= Double.parseDouble(itemInformation[2]);
                            showPrice();
                            orderList.remove(item);
                            list.getChildren().remove(button1);
                        }
                    });
                }
            });
            if (itemInformation[0].equals(CafeItems.FOODS.toString())) {
                type1.getChildren().add(button);
            } else if (itemInformation[0].equals(CafeItems.DESSERTS.toString())) {
                type2.getChildren().add(button);
            } else {
                type3.getChildren().add(button);
            }
        }

    }

    public void showPrice() {
        totalPriceLabel.setText(Double.toString(totalPrice));
    }

    public void order(ActionEvent event) {
        if(orderList.size()==0){
            orderLabel.setText("First choose an Item");
            orderLabel.setTextFill(Color.RED);
        }
        else if (customer.getMoney() < totalPrice) {
            orderLabel.setText("You don't have enough money");
            orderLabel.setTextFill(Color.RED);
        } else {
            customer.setMoney(customer.getMoney() - totalPrice);
            orderLabel.setText("Ordered");
            orderLabel.setTextFill(Color.GREEN);
            Order order = new Order();
            order.setPlaceName(placeName);
            order.setUserEmail(customer.getEmail());
            order.setOrderStatus(Order.orderStatus.NOT_DELIVERED);
            order.setItemsNumber(orderList.size());
            order.setItems(orderList);
            Information.setOrderInformation(order);

            //clear
            orderList = new ArrayList<>();
            totalPrice = 0;
            showPrice();
            list.getChildren().removeAll(list.getChildren());
        }
    }

    @Override
    public void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\customerPage.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        CustomerPageController customerPageController = loader.getController();
        customerPageController.setStage(getStage());
        customerPageController.setCustomer(customer);
        customerPageController.start();
    }
}
