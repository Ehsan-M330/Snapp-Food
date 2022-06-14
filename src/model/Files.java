package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    public static void readRestaurantsFile() throws IOException {
        Scanner reader = new Scanner(new File("restaurants.txt"));
        while (reader.hasNextLine()) {
            String[] temp = reader.nextLine().split(" ");
            Restaurant restaurant = new Restaurant();
            restaurant.setName(temp[0]);
            restaurant.setLocation(temp[1]);
            restaurant.setItemsNumber(Integer.parseInt(temp[2]));
            ArrayList<String> items = new ArrayList<>();
            for (int i = 0; i < restaurant.getItemsNumber(); i++) {
                items.add(reader.nextLine());
            }
            restaurant.setItems(items);
            Information.setRestaurantInformation(restaurant);
        }
        reader.close();
    }

    public static void writeRestaurantInFile(ArrayList<Restaurant> information) throws IOException {
        FileWriter writer = new FileWriter("restaurants.txt");
        for (int i = 0; i < information.size(); i++) {
            writer.write(information.get(i).getName() + " " +
                    information.get(i).getLocation() + " " + information.get(i).getItemsNumber() + "\n");

            for (int t = 0; t < information.get(i).getItemsNumber(); t++) {
                writer.write(information.get(i).getItems().get(t) + "\n");
            }

        }
        writer.close();
    }

    public static void readCafesFile() throws IOException {
        Scanner reader = new Scanner(new File("cafes.txt"));
        while (reader.hasNextLine()) {
            String[] temp = reader.nextLine().split(" ");
            Cafe cafe = new Cafe();
            cafe.setName(temp[0]);
            cafe.setLocation(temp[1]);
            cafe.setItemsNumber(Integer.parseInt(temp[2]));
            ArrayList<String> items = new ArrayList<>();
            for (int i = 0; i < cafe.getItemsNumber(); i++) {
                items.add(reader.nextLine());
            }
            cafe.setItems(items);
            Information.setCafeInformation(cafe);
        }
        reader.close();

    }

    public static void writeCafeInFile(ArrayList<Cafe> information) throws IOException {
        FileWriter writer = new FileWriter("cafes.txt");
        for (int i = 0; i < information.size(); i++) {
            writer.write(information.get(i).getName() + " " +
                    information.get(i).getLocation() + " " + information.get(i).getItemsNumber() + "\n");

            for (int t = 0; t < information.get(i).getItemsNumber(); t++) {
                writer.write(information.get(i).getItems().get(t) + "\n");
            }

        }
        writer.close();
    }

    public static void readCustomersFile() throws IOException {
        Scanner reader = new Scanner(new File("customers.txt"));
        while (reader.hasNextLine()) {
            String[] temp = reader.nextLine().split(" ");
            Customer customer = new Customer();
            customer.setName(temp[0]);
            customer.setLastName(temp[1]);
            customer.setPhoneNumber(temp[2]);
            customer.setEmail(temp[3]);
            customer.setPassword(temp[4]);
            customer.setMoney(Double.parseDouble(temp[5]));
            Information.setCustomerInformation(customer);
        }
        reader.close();
    }

    public static void writeCustomersInFile(ArrayList<Customer> information) throws IOException {
        FileWriter writer = new FileWriter("customers.txt");
        for (int i = 0; i < information.size(); i++) {
            writer.write(information.get(i).getName() + " " + information.get(i).getLastName() + " "
                    + information.get(i).getPhoneNumber() + " " + information.get(i).getEmail()
                    + " " + information.get(i).getPassword() + " " + information.get(i).getMoney() + "\n");
        }
        writer.close();
    }

    public static void readDeliveriesFile() throws IOException {
        Scanner reader = new Scanner(new File("deliveries.txt"));
        while (reader.hasNextLine()) {
            String[] temp = reader.nextLine().split(" ");
            Delivery delivery = new Delivery();
            delivery.setName(temp[0]);
            delivery.setLastName(temp[1]);
            delivery.setPhoneNumber(temp[2]);
            delivery.setEmail(temp[3]);
            delivery.setPassword(temp[4]);
            Information.setDeliveryInformation(delivery);
        }
        reader.close();
    }

    public static void writeDeliveriesInFile(ArrayList<Delivery> information) throws IOException {
        FileWriter writer = new FileWriter("deliveries.txt");
        for (int i = 0; i < information.size(); i++) {
            writer.write(information.get(i).getName() + " " + information.get(i).getLastName() + " "
                    + information.get(i).getPhoneNumber() + " " + information.get(i).getEmail()
                    + " " + information.get(i).getPassword() + "\n");
        }
        writer.close();
    }

    public static void readOrdersFile() throws IOException {
        Scanner reader = new Scanner(new File("orders.txt"));
        while (reader.hasNextLine()) {
            String[] temp = reader.nextLine().split(" ");
            Order order = new Order();
            order.setPlaceName(temp[0]);
            order.setUserEmail(temp[1]);
            order.setOrderStatus(Order.orderStatus.valueOf(temp[2]));
            order.setItemsNumber(Integer.parseInt(temp[3]));
            ArrayList<String> items = new ArrayList<>();
            for (int i = 0; i < order.getItemsNumber(); i++) {
                items.add(reader.nextLine());
            }
            order.setItems(items);
            Information.setOrderInformation(order);
        }
        reader.close();
    }

    public static void writeOrdersInFile(ArrayList<Order> information) throws IOException {
        FileWriter writer = new FileWriter("orders.txt");
        for (int i = 0; i < information.size(); i++) {
            writer.write(information.get(i).getPlaceName() + " " + information.get(i).getUserEmail() +
                    " " + information.get(i).getOrderStatus() + " " + information.get(i).getItemsNumber() + "\n");
            for (int t = 0; t < information.get(i).getItemsNumber(); t++) {
                writer.write(information.get(i).getItems().get(t) + "\n");
            }
        }
        writer.close();
    }
}
