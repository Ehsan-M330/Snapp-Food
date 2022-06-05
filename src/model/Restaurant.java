package model;

import java.util.ArrayList;

public class Restaurant extends Place{
    ArrayList<String>items=new ArrayList<>();

    public void setItems(ArrayList<String>items){
        this.items=items;
    }

    public ArrayList<String> getItems(){
        return items;
    }
}
