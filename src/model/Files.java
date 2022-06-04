package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    public static ArrayList<String> readRestaurantsFile() throws IOException {
        ArrayList<String>restaurantsFileInformation=new ArrayList<>();
        Scanner reader = new Scanner(new File("restaurants.txt"));
        while(reader.hasNextLine()){
            restaurantsFileInformation.add(reader.nextLine());
        }
        reader.close();
        return restaurantsFileInformation;
    }

    public static void writeRestaurantInFile(String information) throws IOException{
        FileWriter writer=new FileWriter("restaurants.txt",true);
        writer.write(information+"\n");
        writer.close();
    }
}
