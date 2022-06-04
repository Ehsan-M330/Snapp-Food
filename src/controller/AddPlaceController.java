package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.TypeOfPlace;

import java.io.IOException;
import java.util.regex.Pattern;

public class AddPlaceController extends Helper {
    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    VBox type1, type2, type3;
    @FXML
    TextField itemName, itemPrice;
    @FXML
    Label itemLabel;
    TypeOfPlace typeOfPlace;

    public void start(TypeOfPlace typeOfPlace) {
        this.typeOfPlace = typeOfPlace;
        if (typeOfPlace.equals(TypeOfPlace.RESTAURANT)) {
            choiceBox.getItems().addAll("Fast Foods", "Iranian Foods", "Drinks");
            choiceBox.setValue("Fast Foods");
        } else {
            choiceBox.getItems().addAll("Foods", "Desserts", "Drinks");
            choiceBox.setValue("Foods");
        }
    }

    public void add(ActionEvent event) {
        if (!isUserUseCorrectForm(itemName.getText())) {
            itemLabel.setText("Use correct format for Name");
        } else if (!isPriceFormatCorrect(itemPrice.getText())) {
            itemLabel.setText("Use correct format for Price");
        } else {
            HBox hBox = new HBox(new Label(" " + itemName.getText() + "  " + itemPrice.getText()));
            if (typeOfPlace.equals(TypeOfPlace.RESTAURANT)) {
                switch (choiceBox.getValue()) {
                    case "Fast Foods":
                        type1.getChildren().add(hBox);
                        break;
                    case "Iranian Foods":
                        type2.getChildren().add(hBox);
                        break;
                    case "Drinks":
                        type3.getChildren().add(hBox);
                }

            } else {
                switch (choiceBox.getValue()) {
                    case "Foods":
                        type1.getChildren().add(hBox);
                        break;
                    case "Desserts":
                        type2.getChildren().add(hBox);
                        break;
                    case "Drinks":
                        type3.getChildren().add(hBox);
                }
            }

        }


    }

    public boolean isUserUseCorrectForm(String str) {
        return Pattern.matches("[0-9-a-z-A-Z]{4,}", str);
    }

    public boolean isPriceFormatCorrect(String str) {
        return Pattern.matches("[1-9][0-9]{0,}", str);
    }

    @Override
    public void back(ActionEvent event) throws IOException {

    }
}
