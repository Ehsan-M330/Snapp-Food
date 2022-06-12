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
import java.util.regex.Pattern;

public class AddDeliveryController extends Helper {
    @FXML
    TextField name, lastName, phoneNumber, email, password;
    @FXML
    Label label;

    @FXML
    private ImageView Error;

    @FXML
    private ImageView Tick;

    @FXML
    private Button addbuton;

    @FXML
    private Button backbutton;

    @FXML
    void Style1(MouseEvent event) {
        backbutton.setCursor(Cursor.HAND);
    }

    @FXML
    void Style2(MouseEvent event) {
        addbuton.setCursor(Cursor.HAND);
    }

    public void add(ActionEvent event) throws IOException {
        if (!isUserUseCorrectForm(name.getText())) {
            label.setText("incorrect Name...");
            label.setTextFill(Color.RED);
            Tick.setVisible(false);
            Error.setVisible(true);
        } else if (!isUserUseCorrectForm(lastName.getText())) {
            label.setText("incorrect Last Name...");
            label.setTextFill(Color.RED);
            Tick.setVisible(false);
            Error.setVisible(true);
        } else if (!isPhoneNumberCorrect(phoneNumber.getText())) {
            label.setText("incorrect Phone Number...");
            label.setTextFill(Color.RED);
            Tick.setVisible(false);
            Error.setVisible(true);
        } else if (!isEmailCorrect(email.getText())) {
            label.setText("invalid Email...");
            label.setTextFill(Color.RED);
            Tick.setVisible(false);
            Error.setVisible(true);
        } else if (!isUserUseCorrectForm(password.getText())) {
            label.setText("incorrect Password...");
            label.setTextFill(Color.RED);
            Tick.setVisible(false);
            Error.setVisible(true);
        } else {
            //check for unrepeated email
            ArrayList<Customer> customers = Information.getCustomersInformation();
            ArrayList<Delivery> deliveries = Information.getDeliveriesInformation();

            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getEmail().equals(email.getText())) {
                    label.setText("This Email not available");
                    label.setTextFill(Color.RED);
                    Tick.setVisible(false);
                    Error.setVisible(true);
                    return;
                }
            }

            for (int i = 0; i < deliveries.size(); i++) {
                if (deliveries.get(i).getEmail().equals(email.getText())) {
                    label.setText("This Email not available");
                    label.setTextFill(Color.RED);
                    Tick.setVisible(false);
                    Error.setVisible(true);
                    return;
                }
            }
            label.setText("Added");
            label.setTextFill(Color.BLUE);
            Tick.setVisible(true);
            Error.setVisible(false);

            //add new delivery
            Delivery delivery = new Delivery();
            delivery.setName(name.getText());
            delivery.setLastName(lastName.getText());
            delivery.setPhoneNumber(phoneNumber.getText());
            delivery.setEmail(email.getText());
            delivery.setPassword(password.getText());
            Information.setDeliveryInformation(delivery);

            //clear
            name.setText("");
            lastName.setText("");
            phoneNumber.setText("");
            email.setText("");
            password.setText("");
        }
    }

    public boolean isUserUseCorrectForm(String str) {
        return Pattern.matches("[0-9-a-z-A-Z]{4,}", str);
    }

    public boolean isPhoneNumberCorrect(String str) {
        return Pattern.matches("[0][9][0-9]{9}", str);
    }

    public boolean isEmailCorrect(String str) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(str).matches();
    }

    @Override
    public void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\adminPage.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        AdminPageController adminPageController = loader.getController();
        adminPageController.setStage(getStage());
    }
}
