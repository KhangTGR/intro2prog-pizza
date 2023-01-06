package Controller;

import Model.Product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class changeModifier {

    public void alterProductData(String path,Product product, String id ) {
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


}
