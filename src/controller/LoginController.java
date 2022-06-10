package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Customer;
import model.Delivery;
import model.Information;

import java.io.IOException;
import java.util.ArrayList;


public class LoginController extends Helper {

    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    Label label;

    @FXML
    private ImageView ErrorIcon;

    @FXML
    private Button backButton;

    @FXML
    private Button loginbutton;

    @FXML
    void style1(MouseEvent event) {
        loginbutton.setCursor(Cursor.HAND);
    }

    @FXML
    void style2(MouseEvent event) {
        backButton.setCursor(Cursor.HAND);
    }

    public void login(ActionEvent event) throws IOException {
        //check for admin entry
        if (userName.getText().equals("admin") && password.getText().equals("admin")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\adminPage.fxml"));
            loader.load();
            getStage().setScene(new Scene(loader.getRoot()));
            AdminPageController adminPageController = loader.getController();
            adminPageController.setStage(getStage());
        } else {
            //get information
            ArrayList<Customer> customers = Information.getCustomersInformation();
            ArrayList<Delivery> deliveries = Information.getDeliveriesInformation();

            //check
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getEmail().equals(userName.getText()) && customers.get(i).getPassword().equals(password.getText())) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\customerPage.fxml"));
                    loader.load();
                    getStage().setScene(new Scene(loader.getRoot()));
                    CustomerPageController customerPageController = loader.getController();
                    customerPageController.setStage(getStage());
                    customerPageController.setCustomer(customers.get(i));
                    customerPageController.start();
                    return;
                }
            }
            for (int i = 0; i < deliveries.size(); i++) {
                if (deliveries.get(i).getEmail().equals(userName.getText()) && deliveries.get(i).getPassword().equals(password.getText())) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\deliveryPage.fxml"));
                    loader.load();
                    getStage().setScene(new Scene(loader.getRoot()));
                    DeliveryPageController deliveryPageController = loader.getController();
                    deliveryPageController.setStage(getStage());
                    deliveryPageController.start();
                    return;
                }
            }
            label.setText("Wrong information");
            label.setTextFill(Color.RED);
            ErrorIcon.setVisible(true);
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
