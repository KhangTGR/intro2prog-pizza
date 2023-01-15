package Controller;
import Model.Category;
import utility.generatedId;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;



public class categoryModifier {
    private final String categoryRoute = "src/Data/category.txt";

    public boolean verifiableUniqueCategory (String categoryName) {
        boolean unique = true;
        dataModifier data = new dataModifier();
        ArrayList<String> categoryList = data.readData(categoryRoute, 1);
        for (String i: categoryList) {
            if (i.trim().equalsIgnoreCase(categoryName.trim())) {
                unique = false;
                break;
            }
        }
        return unique;
    }


    public void addCategoryTXT (Category category) {
        generatedId idCreator = new generatedId();
        try {
            FileWriter fd = new FileWriter(this.categoryRoute, true);
            BufferedWriter bw = new BufferedWriter(fd);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("CAT"+idCreator.idAdditioner(this.categoryRoute)+";"+category.getCategoryName());
            pw.flush();
            pw.close();
            System.out.println("Your category has been added successfully !!!");


        }catch (Exception e) {
            System.out.println("Potential issues could exist... Failed !!! ");

        }

    }

}
