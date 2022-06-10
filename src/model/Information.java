package model;

import java.util.ArrayList;

public class Information {

    private static ArrayList<Customer> customersInformation = new ArrayList<>();

    public static void setCustomerInformation(Customer customer) {
        customersInformation.add(customer);
    }

    public static ArrayList<Customer> getCustomersInformation() {
        return customersInformation;
    }


    private static ArrayList<Delivery> deliveriesInformation = new ArrayList<>();

    public static void setDeliveryInformation(Delivery delivery) {
        deliveriesInformation.add(delivery);
    }

    public static ArrayList<Delivery> getDeliveriesInformation() {
        return deliveriesInformation;
    }


    private static ArrayList<Cafe> cafesInformation = new ArrayList<>();

    public static void setCafeInformation(Cafe cafe) {
        cafesInformation.add(cafe);
    }

    public static ArrayList<Cafe> getCafesInformation() {
        return cafesInformation;
    }

    private static ArrayList<Restaurant> restaurantsInformation = new ArrayList<>();

    public static void setRestaurantInformation(Restaurant restaurant) {
        restaurantsInformation.add(restaurant);
    }

    public static ArrayList<Restaurant> getRestaurantsInformation() {
        return restaurantsInformation;
    }


    private static ArrayList<Order> ordersInformation = new ArrayList<>();

    public static void setOrderInformation(Order order) {
        ordersInformation.add(order);
    }

    public static ArrayList<Order> getOrdersInformation() {
        return ordersInformation;
    }
}
