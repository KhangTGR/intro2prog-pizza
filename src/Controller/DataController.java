package Controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataController {
    public ArrayList<String> readData(String filepath, int index) throws IOException {
        ArrayList<String> dataValues = new ArrayList<>();
        String line;
        FileReader fileReader;
        try {
            fileReader = new FileReader(filepath);
        } catch (FileNotFoundException f) {
            throw new RuntimeException(f);
        }
        try {
            BufferedReader br = new BufferedReader(fileReader);
            while ((line = br.readLine()) != null) {
                dataValues.add(line.split(";")[index]);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return dataValues;
    }


    public ArrayList<String> readDataByLines(String path, int index)   {
        String line;
        ArrayList<String> dataValues = new ArrayList<>();
        try {
            line = Files.readAllLines(Paths.get(path)).get(index);
            Collections.addAll(dataValues, line.split(";"));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return dataValues;
    }

}

