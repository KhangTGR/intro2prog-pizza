package utility;
import Controller.dataModifier;
import Controller.orderModifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class displayData {

    public void displayGoods () {
        String route ="src/Data/items.txt";
        dataModifier data = new dataModifier();
        generatedId  lineNumber =  new generatedId();
        ArrayList<String> productIdList  =  data.readData(route, 0);
        ArrayList<String> productTitleList = data.readData(route, 1);
        ArrayList<String> productPriceList = data.readData(route, 2);
        ArrayList<String> productCategoryList = data.readData(route, 3);

        for ( int i = 0; i < lineNumber.idAdditioner(route); i++) {
            System.out.printf("%15s %5s %25s %5s %15s %5s %15s \n ", productIdList.get(i),"|", productTitleList.get(i), "|",productPriceList.get(i),"|",productCategoryList.get(i));
        }
    }

    public void displayClientInformation (String username)  {
        String route = "src/Data/Customer.txt";
        dataModifier data  = new dataModifier();
        generatedId lineNumber = new generatedId();
        ArrayList<String> customerIdList = data.readData(route, 0);
        ArrayList<String> customerName = data.readData(route, 1);
        ArrayList<String> customerPhone = data.readData(route, 4);
        ArrayList<String> customerMemberShip = data.readData(route, 5);
        ArrayList<String> customerUserName = data.readData(route, 2);

        for (int i = 0; i < lineNumber.idAdditioner(route); i++) {
            if (customerUserName.get(i).equals(username)){
                System.out.printf("%15s %5s %25s %5s %15s %5s %15s %5s %15s\n", customerIdList.get(i), "|", customerName.get(i), "|",customerUserName.get(i), "|",customerPhone.get(i), "|",customerMemberShip.get(i));
            }
            }

    }

    public void sortCategory(String category)  {
            String route = "src/Data/items.txt";
            dataModifier data = new dataModifier();
            generatedId lineNumber = new generatedId();
            ArrayList<String> productIdList = data. readData(route , 0);
            ArrayList<String> productTitleList = data. readData(route, 1);
            ArrayList<String> productPriceList  = data.readData(route, 2);
            ArrayList<String> productCategoryList = data.readData(route, 3);

            for (int i = 0; i < lineNumber.idAdditioner(route); i++) {
                if(productCategoryList.get(i).equals(category)){
                    System.out.printf("%15s %5s %25s %5s %15s %5s %15s \n ", productIdList.get(i),"|", productTitleList.get(i), "|",productPriceList.get(i),"|",productCategoryList.get(i));
                }

            }
    }

    public void sortPrice(double min, double max)  {
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

            System.out.printf("%15s %5s %25s %5s %15s %5s %15s \n", "ID","|", "title", "|","price", "|", "category");
            Collections.sort(sortPriceList);
            for (double sort: sortPriceList) {
                for ( int i = 0; i < lineNumber.idAdditioner(route) - 1; i++) {

                    if(sort == Double.parseDouble(productPriceList.get(i))) {
                        System.out.printf("%15s %5s %25s %5s %15s %5s %15s \n", productIdList.get(i),"|", productTitleList.get(i), "|",productPriceList.get(i),"|",productCategoryList.get(i));
                    }
                }

            }


    }
    public void displayOrdersByCustomerID(String clientID) {
        String path = "src/Data/Orders.txt";
        generatedId lineCount = new generatedId();
        dataModifier data = new dataModifier();
        ArrayList<String> orderID = data.readData(path, 0);
        ArrayList<String> orderDate = data.readData(path, 1);
        ArrayList<String> orderProductTitle = data.readData(path, 2);
        ArrayList<String> orderQuantity = data.readData(path, 3);
        ArrayList<String> orderSubtotal = data.readData(path, 4);
        ArrayList<String> orderTotal = data.readData(path, 5);
        ArrayList<String> orderClientID = data.readData(path, 6);
        ArrayList<String> orderUserName = data.readData(path, 7);
        ArrayList<String> orderClientTel = data.readData(path, 8);
        ArrayList<String> orderStatus = data.readData(path, 9);
        System.out.printf("%15s %5s %30s %5s %15s %5s %15s %5s %15s %5s %15s %5s %15s %5s %15s %5s %15s %5s %15s\n", "orderID","|", "Date", "|","Product", "|", "Quantity", "|","Subtotal","|","Total","|","Status", "|","Customer Id", "|","Customer Name", "|","Tel");

        for (int i = 0; i < lineCount.idAdditioner(path); i++) {

            if(orderClientID.get(i).equals(clientID)){

                System.out.printf("%15s %5s %30s %5s %15s %5s %15s %5s %15s %5s %15s %5s %15s %5s %15s %5s %15s %5s %15s\n", orderID.get(i),"|", orderDate.get(i), "|",orderProductTitle.get(i), "|",orderQuantity.get(i), "|",orderSubtotal.get(i), "|",orderTotal.get(i),"|",orderStatus.get(i), "|",orderClientID.get(i), "|",orderUserName.get(i), "|",orderClientTel.get(i));

            }

        }
    }



    public void displayOrdersByOrderID(String ID) {
        double total = 0;
        String path = "src/Data/Orders.txt";
        orderModifier oM = new orderModifier();
        generatedId genID = new generatedId();
        dataModifier data = new dataModifier();
        ArrayList<String> orderID = data.readData(path, 0);
        ArrayList<String> orderDate = data.readData(path, 1);
        ArrayList<String> orderProductTitle = data.readData(path, 2);
        ArrayList<String> orderQuantity = data.readData(path, 3);
        ArrayList<String> orderSubTotal = data.readData(path,4);
        ArrayList<String> orderTotal = data.readData(path, 5);
        ArrayList<String> orderStatus = data.readData(path, 9);
        System.out.printf("%10s %5s %30s %5s %20s %5s %10s %5s %10s %5s %15s %5s %25s\n", "orderID","|", "Date", "|","Product", "|", "Quantity", "|","Subtotal", "|","Total", "|","Status");
        for(int i = 0; i < genID.idAdditioner(path); i++) {
            if(orderID.get(i).equals(ID)) {
                System.out.printf("%10s %5s %30s %5s %20s %5s %10s %5s %10s %5s %15s %5s %25s\n", orderID.get(i),"|",orderDate.get(i),"|",orderProductTitle.get(i),"|",orderQuantity.get(i),"|",orderSubTotal.get(i),"|",orderTotal.get(i),"|",orderStatus.get(i));
                System.out.printf("%s\n", "***********************************************************************************");
                if(oM.readRank().equals("Silver")) {
                    System.out.printf("%115s\n", "Discount 10%");
                    System.out.printf("%115s\n","Total: " + total *0.9);
                }else if (oM.readRank().equals("Gold")){
                    System.out.printf("%115s\n", "Discount 20%");
                    System.out.printf("%115s\n", "Total: " + total * 0.8);
                } else if(oM.readRank().equals("Diamond")) {
                    System.out.printf("%115s\n", "Discount 30%");
                    System.out.printf("%115s\n", "Total: " + total * 0.7);
                }else {
                    System.out.printf("%115s\n","Total: " + total);
                }
            }
        }
    }
    public void displayOrderClient(String ID){
        String path = "src/Data/Orders.txt";
        generatedId lineCount = new generatedId();
        dataModifier data = new dataModifier();
        ArrayList<String> orderID = data.readData(path,0);
        ArrayList<String> orderDate = data.readData(path,1);
        ArrayList<String> orderTotal = data.readData(path,5);
        ArrayList<String> orderStatus = data.readData(path,9);
        ArrayList<String> orderClientID = data.readData(path,6);
        System.out.printf("%15s %5s %30s %5s %15s %5s %15s\n", "orderID","|", "Date","|","Total","|","Status");
        for (int i = 0; i < lineCount.idAdditioner(path); i++) {
            if(i == lineCount.idAdditioner(path)-1){
                System.out.printf("%15s %5s %30s %5s %15s %5s %15s\n", orderID.get(i),"|", orderDate.get(i), "|" ,orderTotal.get(i),"|",orderStatus.get(i));
                break;
            }
            if(orderClientID.get(i).equals(ID) && !Objects.equals(orderID.get(i), orderID.get(i + 1))){
                System.out.printf("%15s %5s %30s %5s %15s %5s %15s\n", orderID.get(i),"|", orderDate.get(i), "|" ,orderTotal.get(i),"|",orderStatus.get(i));
            }
        }
    }

    public void displayOrders(){

        String path = "src/Data/Orders.txt";

        generatedId lineCount = new generatedId();

        dataModifier data = new dataModifier();

        ArrayList<String> orderId = data.readData(path,0);

        ArrayList<String> orderDate = data.readData(path,1);

        ArrayList<String> orderTotal = data.readData(path,5);

        ArrayList<String> orderStatus = data.readData(path,9);

        ArrayList<String> orderCustomerId = data.readData(path,6);

        ArrayList<String> orderCustomerName = data.readData(path,7);

        orderDate.remove(0);

        orderTotal.remove(0);

        orderStatus.remove(0);

        orderCustomerId.remove(0);

        orderId.remove(0);

        orderCustomerName.remove(0);

        System.out.printf("%15s %5s %30s %5s %15s %5s %15s %5s %15s %5s %25s\n", "OrderId","|", "Date", "|","Total Price", "|", "Status", "|","CustomerId", "|","Customer Name");

        for (int i = 0; i < lineCount.idAdditioner(path); i++) {

            if(i == lineCount.idAdditioner(path) -2){

                System.out.printf("%15s %5s %30s %5s %15s %5s %15s %5s %15s %5s %25s\n", orderId.get(i),"|", orderDate.get(i), "|",orderTotal.get(i), "|",orderStatus.get(i), "|",orderCustomerId.get(i), "|",orderCustomerName.get(i));

                break;

            }

            if(!Objects.equals(orderId.get(i), orderId.get(i + 1))){

                System.out.printf("%15s %5s %30s %5s %15s %5s %15s %5s %15s %5s %25s\n", orderId.get(i),"|", orderDate.get(i), "|",orderTotal.get(i), "|",orderStatus.get(i), "|",orderCustomerId.get(i), "|",orderCustomerName.get(i));

            }

        }

    }

}
