package Src.Controller;
import Model.OrderList;
import utils.GenerateId;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OrderController {
    String customerID = readLogIn();
    String customerRank = readRank();
    public void addOrderCSV(OrderList orderList) {
        GenerateId idCreator = new GenerateId();
        try {
            String orderPath = "src/Database/Order.csv";
            long Id = idCreator.idIncrementor(orderPath);
            FileWriter filew = new FileWriter(orderPath, true);
            BufferedWriter bw = new BufferedWriter(filew);
            PrintWriter printw = new PrintWriter(bw);
            for(int i =0; i<(orderList.getOrders()).size();i++){
                printw.println("ORD" + Id + ";" +orderList.getDate() + ";" + (((orderList.getOrders()).get(i)).getProduct()).getName() + ";" + (((orderList.getOrders()).get(i)).getQuantity())  + ";" + (((orderList.getOrders()).get(i)).getTotal()) + ";" + orderList.getTotal() +";" + customerID + ";" + (orderList.getCustomer()).getFullName() + ";" + (orderList.getCustomer()).getPhoneNum() + ";" + "Delivered");
            }
            printw.flush();
            printw.close();
        } catch (Exception E) {
            System.out.println("It might be some problem, running failed");
        }
    }


    public String readLogIn(){
        String customerID = null;
        DataController dc = new DataController();
        ArrayList<String> usernameList = dc.readData("src/DataBase/LoginUser.csv", 0);
        String username = usernameList.get(0);
        ArrayList<String> customerIdList = dc.readData("src/DataBase/CustomerRegister.csv", 0);
        ArrayList<String> customerUserNameList = dc.readData("src/DataBase/CustomerRegister.csv", 3);
        GenerateId lineCount = new GenerateId();
        for(int i =0; i<lineCount.idIncrementor("src/DataBase/CustomerRegister.csv"); i++){
            if(customerUserNameList.get(i).equals(username)){
                customerID = customerIdList.get(i);
            }
        }
        return customerID;
    }

    public String readRank(){
        String customerRank = null;
        DataController dc = new DataController();
        ArrayList<String> usernameList = dc.readData("src/DataBase/LoginUser.csv", 0);
        String username = usernameList.get(0);
        ArrayList<String> customerRankList = dc.readData("src/DataBase/CustomerRegister.csv", 5);
        ArrayList<String> customerUserNameList = dc.readData("src/DataBase/CustomerRegister.csv", 3);
        GenerateId lineCount = new GenerateId();
        for(int i =0; i<lineCount.idIncrementor("src/DataBase/CustomerRegister.csv"); i++){
            if(customerUserNameList.get(i).equals(username)){
                customerRank = customerRankList.get(i);
            }
        }
        return customerRank;
    }

    public double getTotalUse(){
        double totalUse = 0;
        GenerateId lineCount = new GenerateId();
        DataController dc = new DataController();
        ArrayList<String> customerIdList = dc.readData("src/DataBase/Order.csv",6);
        ArrayList<String> customerExpense = dc.readData("src/DataBase/Order.csv",5);
        ArrayList<String> customerOrderId = dc.readData("src/DataBase/Order.csv",0);
        String customerId = readLogIn();
        for (int i = 0; i < lineCount.idIncrementor("src/DataBase/Order.csv"); i++) {
            if(customerIdList.get(i).equals(customerId)){
                if(i == lineCount.idIncrementor("src/DataBase/Order.csv") -1){
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
