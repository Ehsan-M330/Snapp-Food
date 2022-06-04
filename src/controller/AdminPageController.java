package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import model.TypeOfPlace;


import java.io.IOException;

public class AdminPageController extends Helper{

    public void showRestaurants(ActionEvent event){

    }
    public void addRestaurant(ActionEvent event)throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("..\\view\\addPlace.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        AddPlaceController addPlaceController=loader.getController();
        addPlaceController.setStage(getStage());
        addPlaceController.start(TypeOfPlace.RESTAURANT);
    }

    public void showCafes(ActionEvent event){

    }
    public void addCafe(ActionEvent event) throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("..\\view\\addPlace.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        AddPlaceController addPlaceController=loader.getController();
        addPlaceController.setStage(getStage());
        addPlaceController.start(TypeOfPlace.CAFE);
    }

    public void showDeliveries(ActionEvent event){

    }
    public void addDelivery(ActionEvent event) throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("..\\view\\addDelivery.fxml"));
        loader.load();
        getStage().setScene(new Scene(loader.getRoot()));
        AddDeliveryController addDeliveryController=loader.getController();
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
