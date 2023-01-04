package Controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataController {
    public ArrayList<String> readData(String filepath, int index)  {
        ArrayList<String> dataValues = new ArrayList<>();
        String line;
        FileReader fileReader;
        try {
            fileReader = new FileReader(filepath);
        } catch (FileNotFoundException f) {
            throw new RuntimeException(f);
        }
            try {
                BufferedReader reader = new BufferedReader(fileReader);
                while (true) {
                    line = reader.readLine();
                    if (line != null) {
                        dataValues.add(line.split(";")[index]);
                    } else {
                        break;
                    }
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
