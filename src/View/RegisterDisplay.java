package View;

import Controller.PassWordMasking;
import Controller.RegisterController;
import Model.Customer;

import java.io.IOException;
import java.util.Scanner;

public class RegisterDisplay {
    public static void main(String[] args) throws IOException {

        // Enter customer's full name
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your full name: ");
        String fullName = input.nextLine();
        //Enter customer's username
        System.out.println("Please enter your username: ");
        String username = input.nextLine();
        // Checking for duplicate user
        while (true){
            RegisterController register = new RegisterController();
            if (register.checkExistUser(username)) {
                System.out.println("Your username has already exist! Please try a different username: ");
                username = input.nextLine();
            }else{
                break;
            }
        }
        // Enter customer's password
        System.out.println("Please enter your password: ");
        String password = input.nextLine();
        PassWordMasking passWordMasking = new PassWordMasking();
        System.out.println(passWordMasking.passwordHiding(password));
        // Enter customer's phone number
        System.out.println("Please enter your phone number: ");
        String phoneNum  = input.nextLine();
        Customer customer = new Customer(fullName, username, password, phoneNum);
        RegisterController register = new RegisterController();
        register.createNewAccount(customer);

        }

}