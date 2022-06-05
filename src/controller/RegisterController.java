package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class RegisterController extends Helper {
    @FXML
    TextField email, name, lastName, phoneNumber, password;
    @FXML
    Label label;

    public void register(ActionEvent event) throws IOException {
        if (!isUserUseCorrectForm(name.getText())) {
            label.setText("incorrect Name...");
        } else if (!isUserUseCorrectForm(lastName.getText())) {
            label.setText("incorrect Last Name...");
        } else if (!isPhoneNumberCorrect(phoneNumber.getText())) {
            label.setText("incorrect Phone Number...");
        } else if (!isEmailCorrect(email.getText())) {
            label.setText("invalid Email...");
        } else if (!isUserUseCorrectForm(password.getText())) {
            label.setText("incorrect Password...");
        } else {
            //check for unrepeated email
            ArrayList<String> customersInformation;
            customersInformation = Files.readCustomersFile();
            ArrayList<String> deliveriesInformation;
            deliveriesInformation = Files.readDeliveriesFile();

            for(int i=0;i<customersInformation.size();i++){
                String[] information= customersInformation.get(i).split(" ");
                if(information[3].equals(email.getText())){
                    label.setText("This Email not available");
                    return;
                }
            }

            for(int i=0;i<deliveriesInformation.size();i++){
                String[] information= deliveriesInformation.get(i).split(" ");
                if(information[3].equals(email.getText())){
                    label.setText("This Email not available");
                    return;
                }
            }

            //write in file
            String temp = name.getText() + " " + lastName.getText() + " "
                    + phoneNumber.getText() + " " + email.getText() + " " + password.getText() + " " +"0";
            Files.writeCustomerInFile(temp);
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\firstPage.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        FirstPageController firstPageController = loader.getController();
        firstPageController.setStage(getStage());

    }
}
