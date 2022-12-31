package Controller;

import Model.Customer;

import java.io.Console;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class RegisterController {
    private final String path ="src/Data/Customer.csv";

    public void register(Customer customer) {
        try {
            FileWriter outputfile = new FileWriter(this.path, true);
            PrintWriter pw = new PrintWriter(outputfile);
            Scanner scan = new Scanner(System.in);
            Console c = System.console();

            System.out.println("Please enter your fullname: ");
            String userFullName = scan.nextLine();
            customer.setFullName(userFullName);

            System.out.println("Please enter your username: ");
            String userName = scan.nextLine();
            customer.setUserName(userName);

            char[] passwordArray = c.readPassword("Enter your password");
            for (int i = 0; i < passwordArray.length; i++) {
                System.out.print("*");
            }
            String passWord = String.valueOf(passwordArray);
            customer.setPassWord(passWord);

            System.out.println("Please enter your phone number: ");
            String phoneNum = scan.nextLine();
            customer.setPhoneNum(phoneNum);
            pw.flush();
            pw.close();
            System.out.println("Your new account has been successfully created!");

        }catch (Exception E) {
            System.out.println("Oops! There might be a problem...Please try again!");
        }


    }
}
