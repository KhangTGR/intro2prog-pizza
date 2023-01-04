package Controller;

import Model.Customer;

import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LoginController {
    public HashMap<String, String> passMap(String filepath) throws IOException{
        DataController datacontrol = new DataController();
        HashMap<String, String> passIndex = new HashMap<>();
        ArrayList<String> userNameList = datacontrol.readData(filepath, 2);
        ArrayList<String> passWordList = datacontrol.readData(filepath, 3);
        for(int i = 0; i < userNameList.size(); i++) {
            passIndex.put(userNameList.get(i), passWordList.get(i));
        }
        return passIndex;

    }
    public boolean verification(String userName, String passWord, String filepath) throws IOException {
        if(passMap(filepath).containsKey(userName)) {
            if (passWord.equals(passMap(filepath).get(userName))) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    }

