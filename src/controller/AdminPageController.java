package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


import java.io.IOException;

public class AdminPageController extends Helper{

    public void showRestaurants(ActionEvent event){

    }
    public void addRestaurant(ActionEvent event){

    }

    public void showCafes(ActionEvent event){

    }
    public void addCafe(ActionEvent event){

    }

    public void showDeliveries(ActionEvent event){

    }
    public void addDelivery(ActionEvent event){

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
