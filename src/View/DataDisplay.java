package View;

import Controller.DataController;
import utils.GenerateID;

import java.io.IOException;
import java.util.ArrayList;

public class DataDisplay {
    public void displayStoreProducts() throws IOException {
        String filepath = "src/Data/Items.txt";
        DataController dc = new DataController();
        GenerateID genID = new GenerateID();
        ArrayList<String> productID = dc.readData(filepath, 0);
        ArrayList<String> productName = dc.readData(filepath, 1);
        ArrayList<String> productPrice = dc.readData(filepath,2);
        ArrayList<String> currency = dc.readData(filepath, 3);
        ArrayList<String> productCategory = dc.readData(filepath, 4);


    }
}
