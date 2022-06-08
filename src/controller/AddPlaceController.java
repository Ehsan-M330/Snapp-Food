package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class AddPlaceController extends Helper {

    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    VBox type1, type2, type3;
    @FXML
    TextField itemName, itemPrice, placeName, placeLocation;
    @FXML
    Label itemLabel,type1Label,type2Label,type3Label,titleLabel, placeLabel;

    TypeOfPlace typeOfPlace;
    ArrayList<String> items=new ArrayList<>();
    public void start(TypeOfPlace typeOfPlace) {
        this.typeOfPlace = typeOfPlace;
        if (typeOfPlace.equals(TypeOfPlace.RESTAURANT)) {
            choiceBox.getItems().addAll("Fast Foods", "Iranian Foods", "Drinks");
            choiceBox.setValue("Fast Foods");

            titleLabel.setText("Add Restaurant");
            type1Label.setText("Fast Foods");
            type2Label.setText("Iranian Food");
            type3Label.setText("Drinks");
        } else {
            choiceBox.getItems().addAll("Foods", "Desserts", "Drinks");
            choiceBox.setValue("Foods");

            titleLabel.setText("Add cafe");
            type1Label.setText("Foods");
            type2Label.setText("Desserts");
            type3Label.setText("Drinks");
        }

    }

    public void add(ActionEvent event) {
        if (!isUserUseCorrectForm(itemName.getText())) {
            itemLabel.setText("Use correct format for Name");
            itemLabel.setTextFill(Color.RED);
        } else if (!isPriceFormatCorrect(itemPrice.getText())) {
            itemLabel.setText("Use correct format for Price");
            itemLabel.setTextFill(Color.RED);
        } else {
            HBox hBox = new HBox(new Label(" " + itemName.getText() + "  " + itemPrice.getText()));
            if (typeOfPlace.equals(TypeOfPlace.RESTAURANT)) {
                switch (choiceBox.getValue()) {
                    case "Fast Foods":
                        type1.getChildren().add(hBox);
                        items.add(RestaurantItems.FAST_FOODS+" "+itemName.getText()+" "+itemPrice.getText());
                        break;
                    case "Iranian Foods":
                        type2.getChildren().add(hBox);
                        items.add(RestaurantItems.IRANIAN_FOODS+" "+itemName.getText()+" "+itemPrice.getText());
                        break;
                    case "Drinks":
                        type3.getChildren().add(hBox);
                        items.add(RestaurantItems.DRINKS+" "+itemName.getText()+" "+itemPrice.getText());
                }

            } else {
                switch (choiceBox.getValue()) {
                    case "Foods":
                        type1.getChildren().add(hBox);
                        items.add(CafeItems.FOODS +" "+itemName.getText()+" "+itemPrice.getText());
                        break;
                    case "Desserts":
                        type2.getChildren().add(hBox);
                        items.add(CafeItems.DESSERTS +" "+itemName.getText()+" "+itemPrice.getText());
                        break;
                    case "Drinks":
                        type3.getChildren().add(hBox);
                        items.add(CafeItems.DRINKS +" "+itemName.getText()+" "+itemPrice.getText());
                }
            }
            itemLabel.setText("Item added");
            itemLabel.setTextFill(Color.GREEN);
        }
    }

    public void done(ActionEvent event) throws IOException{
        if(!isUserUseCorrectForm(placeName.getText())){
            placeLabel.setText("Use correct format for Name");
            placeLabel.setTextFill(Color.RED);
        }else if(!isUserUseCorrectForm(placeLocation.getText())){
            placeLabel.setText("Use correct format for Location");
            placeLabel.setTextFill(Color.RED);
        }else if(items.size()==0){
            placeLabel.setText("First add some items");
            placeLabel.setTextFill(Color.RED);
        }else{
            //check for unrepeated name
            ArrayList<Restaurant>restaurants=Information.getRestaurantsInformation();
            ArrayList<Cafe>cafes=Information.getCafesInformation();
            for(int i=0;i<restaurants.size();i++){
                if(placeName.getText().equals(restaurants.get(i).getName())){
                    placeLabel.setText("This name have been used");
                    placeLabel.setTextFill(Color.RED);
                    return;
                }
            }
            for(int i=0;i<cafes.size();i++){
                if(placeName.getText().equals(cafes.get(i).getName())){
                    placeLabel.setText("This name have been used");
                    placeLabel.setTextFill(Color.RED);
                    return;
                }
            }

            //add place
            if(typeOfPlace.equals(TypeOfPlace.RESTAURANT)){
                Restaurant restaurant=new Restaurant();
                restaurant.setName(placeName.getText());
                restaurant.setLocation(placeLocation.getText());
                restaurant.setItemsNumber(items.size());
                restaurant.setItems(items);
                Information.setRestaurantInformation(restaurant);
                placeLabel.setText("Restaurant added");
                placeLabel.setTextFill(Color.GREEN);
            }else{
                Cafe cafe=new Cafe();
                cafe.setName(placeName.getText());
                cafe.setLocation(placeLocation.getText());
                cafe.setItemsNumber(items.size());
                cafe.setItems(items);
                Information.setCafeInformation(cafe);
                placeLabel.setText("Cafe added");
                placeLabel.setTextFill(Color.GREEN);
            }
            //clear page
            type1.getChildren().removeAll(type1.getChildren());
            type2.getChildren().removeAll(type2.getChildren());
            type3.getChildren().removeAll(type3.getChildren());
            items.clear();
            itemLabel.setText("");
            itemPrice.setText("");
            itemName.setText("");
            placeName.setText("");
            placeLocation.setText("");
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
        FXMLLoader loader =new FXMLLoader(getClass().getResource("..\\view\\adminPage.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        AdminPageController adminPageController=loader.getController();
        adminPageController.setStage(getStage());
    }
}
