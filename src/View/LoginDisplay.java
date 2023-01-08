package View;

import Controller.loginModifier;
import utility.PassWordMasking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LoginDisplay {
    public void loginCustomer() throws IOException {
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
            PassWordMasking passWordMasking = new PassWordMasking();
            passWordMasking.passwordHiding(passWord);
            if(!login.verification(userName.trim(), passWord, pathFile )) {
                System.out.println("Incorrect username or password !");
            }else{
                try {
                    FileWriter fw = new FileWriter(loginFile);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw) ;
                    pw.println(userName);
                    pw.println(passWord);
                    pw.flush();
                    pw.close();


                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }while (!login.verification(userName, passWord, pathFile));
    }

    public void loginAdmin() throws IOException {
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
            PassWordMasking passWordMasking = new PassWordMasking();
            passWordMasking.passwordHiding(passWord);
            if(!login.verification(adminName.trim(), passWord, filepath)) {
                System.out.println("Incorrect username or password !");
            }else {
                try{
                    FileWriter fw = new FileWriter(loginfile);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    pw.println(adminName);
                    pw.println(passWord);
                    pw.flush();
                    pw.close();
                }catch (Exception e) {
                    System.out.println("There might be some problems...Failed");
                }
            }
        }while (!login.verification(adminName, passWord, filepath));
    }


}
