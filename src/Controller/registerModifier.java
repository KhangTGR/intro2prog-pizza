package Controller;

import Model.Customer;
import utility.generatedId;

import java.io.*;
import java.util.ArrayList;



public class registerModifier {
    private final String path ="src/Data/Customer.txt";
    private boolean existUser = false;
public boolean checkExistUser(String username) throws IOException {
        dataModifier data = new dataModifier();
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
    generatedId generation = new generatedId();
    try {
        FileWriter fileWriter = new FileWriter(this.path, true);
        BufferedWriter bf = new BufferedWriter(fileWriter);
        PrintWriter pw = new PrintWriter(bf);
        pw.println(generation.idAdditioner(this.path) + ";" + customer.getFullName().trim() + ";" + customer.getUsername() + ";" + customer.getPassword() + ";" + customer.getPhoneNumber() + ";" + "Regular");
        pw.flush();
        pw.close();

    }catch (Exception e) {
        e.printStackTrace();
    }

}
}
