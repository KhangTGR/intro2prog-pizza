package Controller;
import Model.OrderMenu;
import utility.generatedId;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class orderModifier {
    String customerID = readLogIn();
    String customerRank = readRank();


    public void addOrdertxt(OrderMenu orderMenu) {
        generatedId idCreator = new generatedId();
        try {
            String orderPath = "src/Data/Orders.txt";
            long id = idCreator.idAdditioner(orderPath);
            FileWriter filew = new FileWriter(orderPath, true);
            BufferedWriter bw = new BufferedWriter(filew);
            PrintWriter printw = new PrintWriter(bw);
            for (int i = 0; i < (orderMenu.getOrders()).size(); i++) {
                printw.println("ORD" + id + ";" + orderMenu.getDate() + ";" + (((orderMenu.getOrders())).get(i)).getProduct().getTitle() + ";" + (((orderMenu.getOrders())).get(i)).getQuantity() + ";" + (((orderMenu.getOrders())).get(i)).getTotal() + ";" + orderMenu.getTotal() + ";" + customerID + ";" + (orderMenu.getCustomer()).getUsername() + ";" + (orderMenu.getCustomer()).getPhoneNumber() + ";" + "Delivered");
            }
            printw.flush();
            printw.close();
        } catch (Exception E) {
            System.out.println("There might be some problems...Failed");

        }
    }


    public String readLogIn() {
        String customerID = null;
        dataModifier dc = new dataModifier();
        ArrayList<String> usernameList = dc.readData("src/Data/LoginCustomer.txt", 0);
        String username = usernameList.get(0);
        ArrayList<String> customerIdList = dc.readData("src/Data/Customer.txt", 0);
        ArrayList<String> customerUserNameList = dc.readData("src/Data/Customer.txt", 2);
        generatedId lineCount = new generatedId();
        for(int i =0; i<lineCount.idAdditioner("src/Data/Customer.txt"); i++){
            if(customerUserNameList.get(i).equals(username)){
                    customerID = customerIdList.get(i);
                }
            }

        return customerID;
    }

    public String readRank(){
        String customerRank = null;
        dataModifier dc = new dataModifier();
        ArrayList<String> usernameList = dc.readData("src/Data/LoginCustomer.txt", 0);
        String username = usernameList.get(0);
        ArrayList<String> customerRankList = dc.readData("src/Data/Customer.txt", 5);
        ArrayList<String> customerUserNameList = dc.readData("src/Data/Customer.txt", 2);
        generatedId lineCount = new generatedId();
        for(int i =0; i<lineCount.idAdditioner("src/Data/Customer.txt"); i++){
            if(customerUserNameList.get(i).equals(username)){
                customerRank = customerRankList.get(i);
                }
            }
        return customerRank;
    }


    public double getTotalUse() {
        double totalUse = 0;
        generatedId lineCount = new generatedId();
        dataModifier dc = new dataModifier();

        ArrayList<String> customerIdList = dc.readData("src/Data/Orders.txt",6);
        ArrayList<String> customerExpense = dc.readData("src/Data/Orders.txt",5);
        ArrayList<String> customerOrderId = dc.readData("src/Data/Orders.txt",0);
        String customerId = readLogIn();
        for (int i = 0; i < lineCount.idAdditioner("src/Data/Orders.txt"); i++) {
            if(customerIdList.get(i).equals(customerId)){
                if(i == lineCount.idAdditioner("src/Data/Orders.txt") -1){
                    totalUse += Double.parseDouble(customerExpense.get(i));
                    break;
                    }
                if(customerOrderId.get(i).equals(customerOrderId.get(i+1))){
                    continue;
                    }
                totalUse += Double.parseDouble(customerExpense.get(i));
                }
            }
        return totalUse;
    }

}
