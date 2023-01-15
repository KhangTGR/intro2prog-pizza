package Controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class dataModifier {
    public ArrayList<String> readData(String path, int index){
        String line;
        ArrayList<String> dataList = new ArrayList<>();
        FileReader fr;
        try {
            fr = new FileReader(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedReader reader = new BufferedReader(fr);
            while (true) {
                line = reader.readLine();
                if (line != null) {
                    dataList.add(line.split(";")[index]);
                } else {
                    break;
                }
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public ArrayList<String> readDataByLine(String path, int index){
        String line;
        ArrayList<String> dataList = new ArrayList<>();
        try{
            line = Files.readAllLines(Paths.get(path)).get(index);
            Collections.addAll(dataList, line.split(";"));
        }
      catch(IOException e){
            System.out.println(e);
        }
        return dataList;
    }
//    public ArrayList<String> readProductData(String path, int index) {
//        String line;
//        ArrayList<String> dataList = new ArrayList<>();
//        FileReader fr;
//        try {
//            fr = new FileReader(path);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            BufferedReader reader = new BufferedReader(fr);
//            while (true) {
//                if ((line = reader.readLine()) != null) {
//                    dataList.add(line.split(";")[index - 1]);
//                }else {
//                    break;
//                }
//            }
//
//
//        }catch (Exception e) {
//            System.setErr(null);
//        }
//        return dataList;
//    }

}


