package Controller;

import java.util.ArrayList;
import java.util.HashMap;

public class loginModifier {
    public HashMap<String, String> passMap(String filepath){
        dataModifier datacontrol = new dataModifier();
        HashMap<String, String> passIndex = new HashMap<>();
        ArrayList<String> userNameList = datacontrol.readData(filepath, 2);
        ArrayList<String> passWordList = datacontrol.readData(filepath, 3);
        for(int i = 0; i < userNameList.size(); i++) {
            passIndex.put(userNameList.get(i), passWordList.get(i));
        }
        return passIndex;

    }
    public boolean verification(String userName, String passWord, String filepath) {
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

