package Controller;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DataFunction {
    public ArrayList<String> readData(String filepath, int index) throws IOException {
        ArrayList<String> dataValues = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader((new FileReader(filepath)))){
            String line = "";
            while ((line = reader.readLine()) != null) {
                dataValues.add(line.split(",")[index - 1]);
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dataValues;
    }
    public ArrayList<String> readDataByLines(String path, int index) throws IOException {
        String line = "";
        ArrayList<String> dataValues = new ArrayList<>();
        try {
            line = Files.readAllLines(Paths.get(path)).get(index);
            Collections.addAll(dataValues, line.split(","));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dataValues;
    }

}
