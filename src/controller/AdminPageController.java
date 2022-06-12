package controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.TypeOfPlace;
import java.io.IOException;

public class AdminPageController extends Helper {

    @FXML
    private Button addCafebutton;

    @FXML
    private Button addDeliverybutton;

    @FXML
    private Button addRestaurantbutton;

    @FXML
    private Button backbutton;

    @FXML
    void Style1(MouseEvent event) {
        backbutton.setCursor(Cursor.HAND);
    }

    @FXML
    void Style2(MouseEvent event) {
        addRestaurantbutton.setCursor(Cursor.HAND);
    }

    @FXML
    void Style3(MouseEvent event) {
        addCafebutton.setCursor(Cursor.HAND);
    }

    @FXML
    void Style4(MouseEvent event) {
        addDeliverybutton.setCursor(Cursor.HAND);
    }

    public void addRestaurant(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\addPlace.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        AddPlaceController addPlaceController = loader.getController();
        addPlaceController.setStage(getStage());
        addPlaceController.start(TypeOfPlace.RESTAURANT);
    }


    public void addCafe(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\addPlace.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        AddPlaceController addPlaceController = loader.getController();
        addPlaceController.setStage(getStage());
        addPlaceController.start(TypeOfPlace.CAFE);
    }


    public void addDelivery(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\view\\addDelivery.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        AddDeliveryController addDeliveryController = loader.getController();
        addDeliveryController.setStage(getStage());
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
