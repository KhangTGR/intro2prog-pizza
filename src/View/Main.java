/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Pham Ngoc Huy, Nguyen Trong Khang, Nguyen Huynh Quang, An Vo Minh Thien
  ID: S3926681, S3926681, S3927039, S3916570
  Acknowledgement: Acknowledge the resources that you use here.
*/


package View;
import Controller.loginModifier;
import Controller.orderModifier;
import Controller.productModifier;
import Controller.registerModifier;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("COSC2081 GROUP ASSIGNMENT ");

        System.out.println("Instructor: Mr. Tom Huynh ");

        System.out.println("Group name: javA");

        System.out.println("s3926681, Pham Ngoc Huy");

        System.out.println("s3929994, Nguyen Trong Khang");

        System.out.println("s3927039, Nguyen Huynh Quang");

        System.out.println("s3916570, An Vo Mnh Thien");

        System.out.println("Welcome to the Store Order Management System");

        System.out.println("====================");

        menu();

    }

    public static void menu()  {
        orderModifier om = new orderModifier();
        Scanner scan = new Scanner(System.in);
        int option;
        System.out.println("===========WELCOME TO ORDER SYSTEM ===================\n" +
                "1. Sign in as Client\n" +
                "2. Sign in as Admin\n" +
                "3. Sign up as Client\n" +
                "4. Exit\n"
            );
        System.out.println("Please enter your choice:");
        option = scan.nextInt();
        switch(option) {
            case 1:
                loginDisplay loginCustomer = new loginDisplay();
                loginCustomer.loginCustomer();
                break;
            case 2:
                loginDisplay loginAdmin = new loginDisplay();
                loginAdmin.loginAdmin();
                break;
            case 3:
                loginDisplay signUp = new loginDisplay();
                signUp.createAccount();
            case 4:
                System.out.println("Goodbye");
            default:
                System.out.println("Invalid choice");
        }




    }



}








