package Controller;
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
        GenerateId idMaker = new GenerateId();
        try {
            String orderPath = "src/Data/Order.csv";
            long Id = idMaker.idIncrementor(orderPath);
            FileWriter fw = new FileWriter(orderPath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for(int i =0; i<(orderList.getOrders()).size();i++){
                pw.println("ORD" + Id + ";" +orderList.getDate() + ";" + (((orderList.getOrders()).get(i)).getProduct()).getName() + ";" + (((orderList.getOrders()).get(i)).getQuantity())  + ";" + (((orderList.getOrders()).get(i)).getTotal()) + ";" + orderList.getTotal() +";" + customerID + ";" + (orderList.getCustomer()).getFullName() + ";" + (orderList.getCustomer()).getPhoneNum() + ";" + "Delivered");
            }
            pw.flush();
            pw.close();
        } catch (Exception E) {
            System.out.println("There might be some problem... Failed");
        }
    }


    public String readLogIn(){
        String customerID = null;
        DataController dc = new DataController();
        ArrayList<String> usernameList = dc.readData("src/Data/LoginUser.csv", 0);
        String username = usernameList.get(0);
        ArrayList<String> customerIdList = dc.readData("src/Data/CustomerRegister.csv", 0);
        ArrayList<String> customerUserNameList = dc.readData("src/Data/CustomerRegister.csv", 3);
        GenerateId lineCount = new GenerateId();
        for(int i =0; i<lineCount.idIncrementor("src/Data/CustomerRegister.csv"); i++){
            if(customerUserNameList.get(i).equals(username)){
                customerID = customerIdList.get(i);
            }
        }
        return customerID;
    }

    public String readRank(){
        String customerRank = null;
        DataController dc = new DataController();
        ArrayList<String> usernameList = dc.readData("src/Data/LoginUser.csv", 0);
        String username = usernameList.get(0);
        ArrayList<String> customerRankList = dc.readData("src/Data/CustomerRegister.csv", 5);
        ArrayList<String> customerUserNameList = dc.readData("src/Data/CustomerRegister.csv", 3);
        GenerateId lineCount = new GenerateId();
        for(int i =0; i<lineCount.idIncrementor("src/Data/CustomerRegister.csv"); i++){
            if(customerUserNameList.get(i).equals(username)){
                customerRank = customerRankList.get(i);
            }
        }
        return customerRank;
    }

    public double getTotalExpense(){
        double totalExpense = 0;
        GenerateId lineCount = new GenerateId();
        DataController dc = new DataController();
        ArrayList<String> customerIdList = dc.readData("src/Data/Order.csv",6);
        ArrayList<String> customerExpense = dc.readData("src/Data/Order.csv",5);
        ArrayList<String> customerOrderId = dc.readData("src/Data/Order.csv",0);
        String customerId = readLogIn();
        for (int i = 0; i < lineCount.idIncrementor("src/Data/Order.csv"); i++) {
            if(customerIdList.get(i).equals(customerId)){
                if(i == lineCount.idIncrementor("src/Data/Order.csv") -1){
                    totalExpense += Double.parseDouble(customerExpense.get(i));
                    break;
                }
                if(customerOrderId.get(i).equals(customerOrderId.get(i+1))){
                    continue;
                }
                totalExpense += Double.parseDouble(customerExpense.get(i));
            }
        }
        return totalExpense;
    }

}
