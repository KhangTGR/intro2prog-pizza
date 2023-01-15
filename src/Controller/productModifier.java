package Controller;

import Model.Product;
import utility.generatedId;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class productModifier {

    private final String route = "src/Data/items.txt";
    private boolean itDuplicate = false;

    public boolean uniqueValidator(String productTitle) {
        dataModifier productData = new dataModifier();
        ArrayList<String> productTitleList = productData.readData(route, 1);
        for (String s: productTitleList) {
            if ((productTitle.trim()).equals(s)) {
               itDuplicate = true;
               break;
            }
        }
        return itDuplicate;
    }


    public void addProductTXT(Product goods) {
        generatedId idAdditioner = new generatedId();
        try {
            FileWriter fwrite = new FileWriter(this.route, true);
            BufferedWriter bwriter = new BufferedWriter(fwrite);
            PrintWriter pwriter = new PrintWriter(bwriter);
            pwriter.println ("ITM" + idAdditioner.idAdditioner(this.route) + ";" + goods.getTitle().trim() +";" +
                    goods.getPrice() + ";" + goods.getCategory());


            pwriter.close();
            pwriter.flush();
            System.out.println(" Your system has been successfully added  !!! ");

        }catch (Exception e) {
            System.out.println("There is an error in your system !!!");
        }

    }

}
