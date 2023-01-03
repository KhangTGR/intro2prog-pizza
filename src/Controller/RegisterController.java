package Controller;

import Model.Customer;
import Model.GenerateID;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RegisterController {
    private final String path ="src/Data/Customer.csv";
    private boolean existUser = false;
public boolean checkExistUser(String username) throws IOException {
        DataFunction data = new DataFunction();
        ArrayList<String> users = data.readData(this.path, 2);
        for(String str: users) {
            if (username.equals(str)) {
                existUser = true;
                break;
            }
        }
        return existUser;
}
public void createNewAccount(Customer customer) throws IOException {
    GenerateID generation = new GenerateID();
    try {
        FileWriter fileWriter = new FileWriter(this.path, true);
        BufferedWriter bf = new BufferedWriter(fileWriter);
        PrintWriter pw = new PrintWriter(bf);
        pw.println(generation.generateID(this.path) + "," + customer.getFullName().trim() + "," + customer.getUsername() + "," + customer.getPassword() + "," + customer.getPhoneNumber());
        pw.flush();
        pw.close();

    }catch (Exception e) {
        e.printStackTrace();
    }

}
}
