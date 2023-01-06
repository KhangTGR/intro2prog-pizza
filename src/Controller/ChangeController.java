package Controller;

import java.io.*;
import java.util.Scanner;

public class ChangeController {
    public void changeCustomerRank(String rank, String filepath, String id ) {
        try {
            String tempFile = "src/Data/tempProducts.txt";
            File oldFile = new File(filepath);
            File newFile = new File(tempFile);
            FileWriter fileWriter = new FileWriter(tempFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            Scanner scan = new Scanner(oldFile);
            scan.useDelimiter("[;\n]");
            scan.nextLine();
            printWriter.println("id;fullname;username;password;phonenumber;rank");
            while (scan.hasNext()) {
                String userID = scan.next();
                String userFullName = scan.next();
                String userUserName = scan.next();
                String userPassWord = scan.next();
                String userPhoneNum = scan.next();
                String userRank = scan.next();
                if (userID.equals(id)) {
                    printWriter.println(userID + ';' + userFullName + ';' + userUserName + ';' + userPassWord + ';' + userPhoneNum + ';' + rank );
                }

                else {
                    printWriter.println(userID + ';' + userFullName + ';' + userUserName + ';' + userPassWord + ';' + userPhoneNum + ';' + userRank);
                }
                scan.close();
                printWriter.flush();
                printWriter.close();
                oldFile.delete();
                File dump = new File(filepath);
                newFile.renameTo(dump);

            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void ChangeOrderStatus(String filepath, String status, String id) {
        try {
            String tempFile = "src/Data/tempProducts.txt";
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
