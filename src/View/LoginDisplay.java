package View;

import Controller.LoginController;
import Controller.PassWordMasking;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LoginDisplay {
    public static void main(String[] args) throws IOException {
        String pathFile = "src/Data/Customer.txt";
        String loginFile = "src/Data/LoginCustomer.txt";
        String userName;
        String passWord;
        Scanner input = new Scanner(System.in);
        LoginController login = new LoginController();
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
}
