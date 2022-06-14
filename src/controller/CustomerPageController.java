package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CustomerPageController extends Helper {
    @FXML
    private Button backbutton;

    @FXML
    private VBox cafeVBox;

    @FXML
    private TextField frinedTextField;

    @FXML
    private Label inviteFriendLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private TextField locationTextField;

    @FXML
    private Label moneyLabel;

    @FXML
    private Label moneyMessageLabel;

    @FXML
    private TextField moneyTextField;

    @FXML
    private VBox orderVBox;

    @FXML
    private VBox restaurantVBox;

    private Customer customer;

    @FXML
    void Styl1(MouseEvent event) {
        backbutton.setCursor(Cursor.HAND);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //get restaurants and cafes information
    private ArrayList<Restaurant> restaurants = Information.getRestaurantsInformation();
    private ArrayList<Cafe> cafes = Information.getCafesInformation();
    private ArrayList<Order> orders = Information.getOrdersInformation();

    public void start() throws IOException {
        setMoneyLabel();

        //show orders
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getUserEmail().equals(customer.getEmail())) {
                Label label = new Label("Place : " + orders.get(i).getPlaceName() + " | Items Number : " + orders.get(i).getItemsNumber() + " | Status : " + orders.get(i).getOrderStatus());
                label.setTextFill(Color.LIGHTBLUE);
                label.setFont(Font.font(15));
                orderVBox.getChildren().add(label);
                for (int t = 0; t < orders.get(i).getItemsNumber(); t++) {
                    Label label1 =new Label(orders.get(i).getItems().get(t));
                    label1.setTextFill(Color.GREEN);
                    label1.setFont(Font.font(18));
                    orderVBox.getChildren().add(label1);
                }
                Label label1 = new Label("-------------------------------------");
                label1.setFont(Font.font(18));
                label1.setTextFill(Color.RED);
                orderVBox.getChildren().add(label1);
            }
        }
    }


    @FXML
    void search1(MouseEvent event) {
        restaurantVBox.getChildren().removeAll(restaurantVBox.getChildren());
        cafeVBox.getChildren().removeAll(cafeVBox.getChildren());
        for (int i = 0; i < restaurants.size(); i++) {
            if (locationTextField.getText().equals(restaurants.get(i).getLocation())) {
                Button button = new Button(restaurants.get(i).getName());
                button.setStyle("-fx-background-color : #ff0000");
                button.setTextFill(Color.LIGHTBLUE);
                restaurantVBox.getChildren().add(button);
                Restaurant restaurant = restaurants.get(i);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\chooseItems.fxml"));
                        try {
                            loader.load();
                            getStage().setScene(new Scene(loader.getRoot()));
                            ChooseItemsController chooseItemsController = loader.getController();
                            chooseItemsController.setStage(getStage());
                            chooseItemsController.start(customer, restaurant);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                });
            }
        }
        for (int i = 0; i < cafes.size(); i++) {
            if (locationTextField.getText().equals(cafes.get(i).getLocation())) {
                Button button = new Button(cafes.get(i).getName());
                button.setStyle("-fx-background-color : #ff0000");
                button.setTextFill(Color.GREEN);
                cafeVBox.getChildren().add(button);
                Cafe cafe = cafes.get(i);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\chooseItems.fxml"));
                        try {
                            loader.load();
                            getStage().setScene(new Scene(loader.getRoot()));
                            ChooseItemsController chooseItemsController = loader.getController();
                            chooseItemsController.setStage(getStage());
                            chooseItemsController.start(customer, cafe);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    @FXML
    void charge1(MouseEvent event) {
        if (chargeRegex(moneyTextField.getText())) {
            customer.setMoney(customer.getMoney() + Double.parseDouble(moneyTextField.getText()));
            setMoneyLabel();
            moneyTextField.setText("");
            moneyMessageLabel.setText("Added");
            moneyMessageLabel.setTextFill(Color.GREEN);
        } else {
            moneyMessageLabel.setText("Use correct format");
            moneyMessageLabel.setTextFill(Color.RED);
        }
    }

    public boolean chargeRegex(String str) {
        return Pattern.matches("[0-9]{1,3}(\\.[0-9]{1,2})?", str);
    }

    public void setMoneyLabel() {
        moneyLabel.setText(Double.toString(customer.getMoney()));
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
