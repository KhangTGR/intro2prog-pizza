package View;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);


       System.out.println("Please enter your full name");
       String askName = scan.nextLine();

       try {
           File myFile = new File("src/Data/category.txt");
           Scanner myObj = new Scanner(myFile);
            while(myObj.hasNextLine()) {
                String data = myObj.nextLine();
                System.out.println(data);
            }
            myObj.close();

       }catch (Exception e) {
                System.out.println(" File is error");
                e.printStackTrace();
       }

        }
    }








