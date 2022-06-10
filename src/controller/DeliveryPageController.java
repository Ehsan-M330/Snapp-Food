package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Information;
import model.Order;

import java.io.IOException;
import java.util.ArrayList;

public class DeliveryPageController extends Helper {
    @FXML
    VBox vBox;

    public void start() {
        ArrayList<Order> orders = Information.getOrdersInformation();
        int i = 0;
        for (; i < orders.size(); i++) {
            if (orders.get(i).getOrderStatus().equals(Order.orderStatus.NOT_DELIVERED)) {
                Button button = new Button("Deliver");
                Label label = new Label("Customer : " + orders.get(i).getUserEmail() + " | Place : " +
                        orders.get(i).getPlaceName() + " | Items Number : " + orders.get(i).getItemsNumber());
                VBox tempVBox = new VBox();
                tempVBox.setSpacing(10);
                tempVBox.setAlignment(Pos.CENTER);
                for (int t = 0; t < orders.get(i).getItemsNumber(); t++) {
                    tempVBox.getChildren().add(new Label(orders.get(i).getItems().get(t)));
                }
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(10);
                hBox.getChildren().addAll(label, button);
                int temp = i;
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        button.setDisable(true);
                        button.setText("Delivered");
                        orders.get(temp).setOrderStatus(Order.orderStatus.DELIVERED);
                    }
                });
                vBox.getChildren().addAll(hBox, tempVBox, new Label("-------------------------------------"));

            }
        }
        if (i == 0) {
            vBox.getChildren().add(new Label("No Order available"));
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
