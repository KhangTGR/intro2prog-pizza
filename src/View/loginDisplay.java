package View;
import Controller.loginModifier;
import Model.Customer;
import utility.passwordMasking;
import Controller.registerModifier;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static View.Main.menu;


public class loginDisplay {


    public void loginCustomer()  {
        String pathFile = "src/Data/Customer.txt";
        String loginFile = "src/Data/LoginCustomer.txt";
        String userName;
        String passWord;
        Scanner input = new Scanner(System.in);
        loginModifier login = new loginModifier();
        do {
            System.out.println("Please enter your username: ");
            userName= input.nextLine();
            System.out.println("Please enter your password: ");
            passWord= input.nextLine();
            passwordMasking PassWordMasking = new passwordMasking();
            PassWordMasking.passwordHiding(passWord);
            if(!login.verification(userName.trim(), passWord, pathFile )) {
                System.out.println("Incorrect username or password !");
            }else{
                try {
                    FileWriter fw = new FileWriter(loginFile);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw) ;
                    pw.println(userName);
                    pw.flush();
                    pw.close();


                }catch (Exception e) {
                    e.printStackTrace();
                }
                customerMenu customerView = new customerMenu();
                customerView.displayMenu();
            }
        }while (!login.verification(userName, passWord, pathFile));
    }

    public void loginAdmin()  {
        String filepath = "src/Data/AdminAccount.txt";
        String loginfile = "src/Data/LoginAdmin.txt";
        String adminName;
        String passWord;
        Scanner input = new Scanner(System.in);
        loginModifier login = new loginModifier();
        do{
            System.out.println("Enter your username: ");
            adminName = input.nextLine();
            System.out.println("Enter your password: ");
            passWord = input.nextLine();
            passwordMasking PassWordMasking = new passwordMasking();
            PassWordMasking.passwordHiding(passWord);
            if(!login.verification(adminName.trim(), passWord, filepath)) {
                System.out.println("Incorrect username or password !");
            }else {
                try{
                    FileWriter fw = new FileWriter(loginfile);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    pw.println(adminName);
                    pw.flush();
                    pw.close();
                }catch (Exception e) {
                    System.out.println("There might be some problems...Failed");
                }
                adminMenu adMinView = new adminMenu();
                adMinView.displayPanel();
            }
        }while (!login.verification(adminName, passWord, filepath));
    }

    public void createAccount()  {
        Scanner scan = new  Scanner(System.in);
        System.out.println("Please enter your full name :");
        String fullname = scan.nextLine();
        System.out.println("Please enter your username :");
        String username = scan.nextLine();
        while(true) {
            registerModifier rm = new registerModifier();
            if (rm.checkExistUser(username)) {
                System.out.println(" This username is available in system. Please choose another username ");
                username = scan.nextLine();
            } else {
                break;
            }
        }
        System.out.println("Please enter your password: ");
        String password = scan.nextLine();
        passwordMasking pM = new passwordMasking();
        pM.passwordHiding(password);
        System.out.println("Please enter your phone number :");
        String phonenumber = scan.nextLine();
        Customer cm = new Customer(fullname,username,password,phonenumber);
        registerModifier rm = new registerModifier();
        rm.createNewAccount(cm);
        menu();

    }

}
