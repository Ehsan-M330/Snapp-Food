package model;

import java.util.ArrayList;

public class Order {
    public enum orderStatus{
        DELIVERED,NOT_DELIVERED;
    }
    private orderStatus orderStatus;

    public Order.orderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Order.orderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    private String placeName, userEmail;
    private ArrayList<String> items = new ArrayList<>();
    private int itemsNumber;

    public int getItemsNumber() {
        return itemsNumber;
    }

    public void setItemsNumber(int itemsNumber) {
        this.itemsNumber = itemsNumber;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}
