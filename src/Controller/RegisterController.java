package Controller;

import Model.Customer;
import utils.GenerateID;

import java.io.*;
import java.util.ArrayList;



public class RegisterController {
    private final String path ="src/Data/Customer.txt";
    private boolean existUser = false;
public boolean checkExistUser(String username) throws IOException {
        DataController data = new DataController();
        ArrayList<String> users = data.readData(this.path, 2);
        for(String s: users) {
            if (username.equals(s)) {
                existUser = true;
                break;
            }
        }
        return existUser;
}
public void createNewAccount(Customer customer) throws ArrayIndexOutOfBoundsException {
    GenerateID generation = new GenerateID();
    try {
        FileWriter fileWriter = new FileWriter(this.path, true);
        BufferedWriter bf = new BufferedWriter(fileWriter);
        PrintWriter pw = new PrintWriter(bf);
        pw.println(generation.idIncrementor(this.path) + ";" + customer.getFullName().trim() + ";" + customer.getUsername() + ";" + customer.getPassword() + ";" + customer.getPhoneNumber() + ";" + "Regular");
        pw.flush();
        pw.close();

    }catch (Exception e) {
        e.printStackTrace();
    }

}
}
