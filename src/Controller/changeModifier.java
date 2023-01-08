package Controller;

import Model.Product;

import java.io.*;
import java.util.Scanner;


public class changeModifier {

    public void alterProductData(String path, Product product, String id ) {
            try {
                String productId;
                double productPrice;
                String productCategory;
                String productTitle;

                // Set Path and Writer function
                String tempDocument = "src/Data/tempItem.txt";
                File oldDocument = new File(path);
                File newDocument = new File(tempDocument);
                FileWriter writer = new FileWriter(tempDocument, true);
                BufferedWriter bwriter = new BufferedWriter(writer);
                PrintWriter pwriter = new PrintWriter(bwriter);

                Scanner scan = new Scanner(new File(path));
                scan.useDelimiter("[;\n]");
                scan.nextLine();

                pwriter.println("id;title;price;category");
                while(scan.hasNext()) {
                    productId = scan.next();
                    productTitle = scan.next();
                    productCategory = scan.next();
                    productPrice = scan.nextDouble();


                    if(productId.equals(id)) {
                        pwriter.println(productId + ";" + product.getTitle() + ";" + product.getPrice()+ ";" +
                                product.getCategory());
                    } else {

                        pwriter.println(productId + ";" + productTitle + productPrice + productCategory);
                    }
                }

                scan.close();
                pwriter.flush();
                pwriter.close();
                oldDocument.delete();
                File unload = new File(path);
                newDocument.renameTo(unload);
                
                System.out.println("Your system has been successfully updated !!! ");
                
                
            }catch (Exception e) {
                System.out.println("There was an error on your system");
                e.printStackTrace();


            }

    }

    public void changeOrderStatus() {
        String route = "src/Data/Orders.txt";



    }
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
