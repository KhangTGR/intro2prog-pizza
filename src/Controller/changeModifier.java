package Controller;

import Model.Product;

import java.io.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;



public class changeModifier {

    public void alterProductData(String path,Product product, String id ) {
            try {
                String productId;
                double productPrice;
                String productCategory;
                String productTitle;

                // Set Path and Writer function
                String tempDocument = "src/Data/tempitems.txt";
                File oldDocument = new File(path);
                File newDocument = new File(tempDocument);
                FileWriter writer = new FileWriter(tempDocument, true);
                BufferedWriter bw = new BufferedWriter(writer);
                PrintWriter pw = new PrintWriter(bw);

                Scanner scan = new Scanner(new File(path));
                scan.useDelimiter("[;\n]");
                scan.nextLine();

                pw.println("id;title;price;category");
                while(scan.hasNext()) {
                    productId = scan.next();
                    productTitle = scan.next();
                    productPrice = scan.nextDouble();
                    productCategory = scan.next();



                    if(productId.equals(id)) {
                        pw.println(productId + ";" + product.getTitle() + ";" + product.getPrice()+ ";" +
                                product.getCategory());
                    } else {
                        pw.println(productId + ";" + productTitle + ";" + productPrice + ";" + productCategory);
                    }
                }

                scan.close();
                pw.flush();
                pw.close();
                oldDocument.delete();
                File unload = new File(path);
                newDocument.renameTo(unload);
                
                System.out.println("Your system has been successfully updated !!! ");
                
                
            }catch (Exception e) {
                System.out.println("There was an error on your system");
            }

    }

    public void changeOrderStatus(String path, String status, String id)  {
        try {
            String routeFile = "src/Data/tempitems.txt";
            String orderingStatus;
            String orderId;
            String orderDate;
            String orderProduct;
            int orderAmount;
            double orderSubtotal;
            double orderSum;
            String orderClientId;
            String orderClientName;
            String orderClientPhone;

            File oldDocument = new File(path);
            File newDocument = new File(routeFile);
            FileWriter fw = new FileWriter(routeFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner scan = new Scanner(new File(path));

            scan.useDelimiter("[;\n]");
            scan.nextLine();

            pw.println("id;date;productName;quantity;subtotal;total;customerId;customerName;phoneNum;status");
            while (scan.hasNext()) {
                orderId = scan.next();
                orderDate = scan.next();
                orderProduct = scan.next();
                orderAmount = scan.nextInt();
                orderSubtotal = scan.nextDouble();
                orderSum = scan.nextDouble();
                orderClientId = scan.next();
                orderClientName = scan.next();
                orderClientPhone = scan.next();
                orderingStatus = scan.next();

                if (orderId.equals(id)) {
                    pw.println(orderId + ";" + orderDate + ";" + orderProduct + ";" + orderAmount + ";" + orderSubtotal + ";"
                            + orderSum + ";" + orderClientId + ";" + orderClientName + ";" + orderClientPhone + ";" + status);
                } else {
                    pw.println(orderId + ";" + orderDate + ";" + orderProduct + ";" + orderAmount + ";" + orderSubtotal + ";" + orderSum + ";"
                            + orderClientId + ";" + orderClientName  + ";" + orderClientPhone + ";" + orderingStatus);
                }

                scan.close();
                pw.flush();
                pw.close();
                oldDocument.delete();
                File dump = new File(path);
                newDocument.renameTo(dump);

                System.out.println("Your data has been successfully updated");

            }
        }
        catch(Exception E){
            System.out.println("There might some problem ... Failed !");
        }

    }

    public void changeCustomerRank(String rank, String filepath, String id ) {
        try {
            String tempFile = "src/Data/tempitems.txt";
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
                String userID = scan.next();
                String userFullName = scan.next();
                String userUserName = scan.next();
                String userPassWord = scan.next();
                String userPhoneNum = scan.next();
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



