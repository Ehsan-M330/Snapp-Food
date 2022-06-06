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
        } else if (!isPriceFormatCorrect(itemPrice.getText())) {
            itemLabel.setText("Use correct format for Price");
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

        }
    }

    public void done(ActionEvent event) throws IOException{
        if(!isUserUseCorrectForm(placeName.getText())){
            placeLabel.setText("Use correct format for Name");
        }else if(!isUserUseCorrectForm(placeLocation.getText())){
            placeLabel.setText("Use correct format for Location");
        }else if(items.size()==0){
            placeLabel.setText("First add some items");
        }else{
            // TODO: 6/5/2022 check for unrepeated restaurant name

            //add place
            if(typeOfPlace.equals(TypeOfPlace.RESTAURANT)){
                Restaurant restaurant=new Restaurant();
                restaurant.setName(placeName.getText());
                restaurant.setLocation(placeLocation.getText());
                restaurant.setItemsNumber(items.size());
                restaurant.setItems(items);
                Information.setRestaurantInformation(restaurant);
            }else{
                Cafe cafe=new Cafe();
                cafe.setName(placeName.getText());
                cafe.setLocation(placeLocation.getText());
                cafe.setItemsNumber(items.size());
                cafe.setItems(items);
                Information.setCafeInformation(cafe);
            }
//            //write place information into file
//            //first write place's name,location and items number
//            String temp= placeName.getText()+" "+ placeLocation.getText()+" "+items.size()+"\n";
//            //then write items information
//            for(int i=0;i<items.size();i++){
//                if(i==items.size()-1){
//                    temp+=items.get(i);
//                }else{
//                    temp+=items.get(i)+"\n";
//                }
//            }
//            if(typeOfPlace.equals(TypeOfPlace.RESTAURANT)){
//                Files.writeRestaurantInFile(temp);
//            }else{
//                Files.writeCafeInFile(temp);
//            }
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
