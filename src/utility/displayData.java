package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



public class displayData {

    public void displayGoods () throws IOException {
        String route ="src/Data/items.txt";
        dataModifier data = new dataModifier();
        generatedId  lineNumber =  new generatedId();
        ArrayList<String> productIdList  =  data.readData(route, 0);
        ArrayList<String> productTitleList = data.readData(route, 1);
        ArrayList<String> productPriceList = data.readData(route, 2);
        ArrayList<String> productCategoryList = data.readData(route, 3);

        for ( int i = 0; i < lineNumber.idAdditioner(route); i++) {
            System.out.printf("%15s %5s %25s %5s %15s %5s %15s %5s %15s\n ", productIdList.get(i),"|", productTitleList.get(i), "|",productPriceList.get(i),"|",productCategoryList.get(i));
        }
    }

    public void displayClientInformation (String username) throws IOException {
        String route = "src/Data/customers.txt";
        dataModifier data  = new dataModifier();
        generatedId lineNumber = new generatedId();
        ArrayList<String> customerIdList = data.readData(route, 0);
        ArrayList<String> customerName = data.readData(route, 1);
        ArrayList<String> customerEmail = data.readData(route, 2);
        ArrayList<String> customerAddress = data.readData(route, 3);
        ArrayList<String> customerPhone = data.readData(route, 4);
        ArrayList<String> customerMemberShip = data.readData(route, 5);
        ArrayList<String> customerUserName = data.readData(route, 6);

        for (int i = 0; i < lineNumber.idAdditioner(route); i++) {

            System.out.printf("%15s %5s %25s %5s %15s %5s %15s %5s %15s\n", customerIdList.get(i),"|", customerName.get(i), "|",customerEmail.get(i), "|",customerAddress.get(i),
                    "|",customerPhone.get(i), "|", customerMemberShip.get(i), "|", customerUserName.get(i));
        }
    }

    public void sortCategory( String category) throws IOException {
            String route = "src/Data/items.txt";
            dataModifier data = new dataModifier();
            generatedId lineNumber = new generatedId();
            ArrayList<String> productIdList = data. readData(route , 0);
            ArrayList<String> productTitleList = data. readData(route, 1);
            ArrayList<String> productPriceList  = data.readData(route, 2);
            ArrayList<String> productCategoryList = data.readData(route, 3);

            for (int i = 0; i < lineNumber.idAdditioner(route); i++) {
                System.out.printf("%15s %5s %25s %5s %15s %5s %15s %5s %15s\n ", productIdList.get(i),"|", productTitleList.get(i), "|",productPriceList.get(i),"|",productCategoryList.get(i));

            }
    }

    public void sortPrice(double min, double max) throws IOException {
            String route = "src/Data/items.txt";
            dataModifier data =  new dataModifier();
            generatedId lineNumber = new generatedId();
            ArrayList<Double> sortPriceList = new ArrayList<>();
            ArrayList<String> productIdList  = data.readData( route, 0);
            ArrayList<String> productTitleList = data.readData( route ,1);
            ArrayList<String> productPriceList = data.readData( route, 2);
            ArrayList<String> productCategoryList = data.readData( route, 3);

            productPriceList.remove(0);
            productTitleList.remove(0);
            productIdList.remove(0);
            productCategoryList.remove(0);

            for (int i = 0; i < lineNumber.idAdditioner(route)-1; i++) {
                    if (Double.parseDouble(productPriceList.get(i)) >= min && Double.parseDouble(productPriceList.get(i)) <= max) {
                        if(!sortPriceList.contains(Double.parseDouble(productPriceList.get(i)))) {
                            sortPriceList.add(Double.valueOf(productPriceList.get(i)));
                        }
                    }
            }

            System.out.printf("%15s %5s %25s %5s %15s %5s %15s %5s %15s\n", "ID","|", "title", "|","price", "|", "category");
            Collections.sort(sortPriceList);
            for (double sort: sortPriceList) {
                for ( int i = 0; i < lineNumber.idAdditioner(route) - 1; i++) {

                    if(sort == Double.parseDouble(productPriceList.get(i))) {
                        System.out.printf("%15s %5s %25s %5s %15s %5s %15s %5s %15s\n", productIdList.get(i),"|", productTitleList.get(i), "|",productPriceList.get(i),"|",productCategoryList.get(i));
                    }
                }

            }


    }


}
