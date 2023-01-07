package Controller;

import java.io.*;
import java.util.Scanner;

public class ChangeController {
    public void changeCustomerRank(String rank, String filepath, String id ) {
        try {
            String tempFile = "src/Data/tempProducts.txt";
            File mainFile = new File(filepath);
            File newFile = new File(tempFile);
            FileWriter fileWriter = new FileWriter(tempFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            Scanner scan = new Scanner(mainFile);
            scan.useDelimiter("[;\n]");
            scan.nextLine();
            printWriter.println("id;fullname;username;password;phonenumber;rank");
            while (scan.hasNext()) {
                String userID = scan.nextLine();
                String userFullName = scan.nextLine();
                String userUserName = scan.nextLine();
                String userPassWord = scan.nextLine();
                String userPhoneNum = scan.nextLine();
                String userRank = scan.nextLine();
                if (userID.equals(id)) {
                    printWriter.println(userID + ';' + userFullName + ';' + userUserName + ';' + userPassWord + ';' + userPhoneNum + ';' + rank );
                }

                else {
                    printWriter.println(userID + ';' + userFullName + ';' + userUserName + ';' + userPassWord + ';' + userPhoneNum + ';' + userRank);
                }
                scan.close();
                printWriter.flush();
                printWriter.close();
                mainFile.delete();
                File dump = new File(filepath);
                newFile.renameTo(dump);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
