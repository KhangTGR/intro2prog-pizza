package Controller;

import java.util.ArrayList;
import java.util.HashMap;

public class loginAdmin {

    public HashMap<String, String> transitionMapping (String path) {

        dataModifier  dm  = new dataModifier();
        HashMap<String, String> transferIndex = new HashMap<>();
        ArrayList<String> userNameList = dm.readData(path, 2);
        ArrayList<String> passwordList = dm.readData(path, 3);
        for (int i = 0; i < userNameList.size(); i++) {
            transferIndex.put(userNameList.get(i), passwordList.get(i));
        }

        return transferIndex;
    }


    public boolean integrated (String userName, String password, String route ) {
            if(transitionMapping(route).containsKey(userName)) {
                if(password.equals(transitionMapping(route).get(userName))) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }

    }
}
