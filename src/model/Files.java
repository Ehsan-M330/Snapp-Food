package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    public static ArrayList<String> readRestaurantsFile() throws IOException {
        ArrayList<String> restaurantsFileInformation = new ArrayList<>();
        Scanner reader = new Scanner(new File("restaurants.txt"));
        while (reader.hasNextLine()) {
            restaurantsFileInformation.add(reader.nextLine());
        }
        reader.close();
        return restaurantsFileInformation;
    }

    public static void writeRestaurantInFile(String information) throws IOException {
        FileWriter writer = new FileWriter("restaurants.txt", true);
        writer.write(information + "\n");
        writer.close();
    }

    public static ArrayList<String> cafesFile() throws IOException {
        ArrayList<String> cafesFileInformation = new ArrayList<>();
        Scanner reader = new Scanner(new File("cafes.txt"));
        while (reader.hasNextLine()) {
            cafesFileInformation.add(reader.nextLine());
        }
        reader.close();
        return cafesFileInformation;
    }

    public static void writeCafeInFile(String information) throws IOException {
        FileWriter writer = new FileWriter("cafes.txt", true);
        writer.write(information + "\n");
        writer.close();
    }

    public static ArrayList<String> readCustomersFile() throws IOException {
        ArrayList<String> customersFileInformation=new ArrayList<>();
        Scanner reader=new Scanner(new File("customers.txt"));
        while (reader.hasNextLine()){
            customersFileInformation.add(reader.nextLine());
        }
        reader.close();
        return customersFileInformation;
    }

    public static void writeCustomerInFile(String information) throws IOException {
        FileWriter writer = new FileWriter("customers.txt", true);
        writer.write(information + "\n");
        writer.close();
    }

    public static ArrayList<String> readDeliveriesFile() throws IOException {
        ArrayList<String> deliveriesFileInformation=new ArrayList<>();
        Scanner reader=new Scanner(new File("deliveries.txt"));
        while (reader.hasNextLine()){
            deliveriesFileInformation.add(reader.nextLine());

        }
        reader.close();
        return deliveriesFileInformation;
    }

    public static void writeDeliveryInFile(String information) throws IOException {
        FileWriter writer = new FileWriter("deliveries.txt", true);
        writer.write(information + "\n");
        writer.close();
    }
}
