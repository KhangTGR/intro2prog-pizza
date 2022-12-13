/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Test 1
  Author: Pham Ngoc Huy
  ID: S3926681
  Created date: 12/03/2022
  Acknowledgement: Acknowledge the resources that you use here.

*/

package Question1;

import java.util.Scanner;

public class FirstFiveAddition {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please typing value of n and m :");
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        printFirstFiveAdditions(n,m);

    }


    public static void printFirstFiveAdditions (int n, int m) {

        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 5 ; i++) {
            System.out.println(n + "+" + i + "*" + m + "=" + (n + i * m));

        }

    }

}
