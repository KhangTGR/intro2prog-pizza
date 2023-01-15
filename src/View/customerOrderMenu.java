package View;
import Model.Customer;
import Model.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.Product;
import utility.displayData;
import utility.generatedId;
import Controller.dataModifier;
import Model.OrderMenu;
import Controller.orderModifier;


public class customerOrderMenu extends customerMenu{
    ArrayList<Order> orderList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    double totalPaid = 0;
    public void displayOrderMenu()  {
        int option;
        System.out.println("ORDER MENU");
        System.out.println("1. Make Order\n2. View Order\n3. Back to main menu\n4. Exit");
        System.out.println("Please enter your option: ");
        option = scan.nextInt();
        switch (option) {
            case 1:
                displayData data = new displayData();
                data.displayGoods();
                addProduct();

                while (true) {
                    System.out.println("Continue adding product? Y/N");
                    String decision = scan.next();
                    if(decision.equals("N") || decision.equals("n")) {
                        System.out.println("Order updated successfully");
                        orderModifier om = new orderModifier();
                        om.addOrdertxt(createOrderList());
                        displayOrderMenu();
                        break;
                    }else {
                        addProduct();
                    }
                }
                break;
            case 2:
                String clientID = readLogin();
                ArrayList<String> orderID = readOrderID();
                displayData display = new displayData();
                display.displayOrderClient(clientID);
                System.out.println("Please enter order ID: ");
                String ID = scan.next();
                boolean found = false;
                while (!found) {
                    if (orderID.contains(ID)) {
                        found = true;
                    }
                    else {
                        System.out.println("Your order ID was not found. Please try again!");
                        ID = scan.next();
                    }
            }
                display.displayOrdersByOrderID(ID);
                displayOrderMenu();
                break;
            case 3:
                customerMenu CustomerMenu = new customerMenu();
                CustomerMenu.displayMenu();
                break;
            case 4:
                System.out.println("Goodbye");
                break;
        }

    }
    public ArrayList<String> readOrderID() {
        String filepath = "src/Data/Orders.txt";
        generatedId genId = new generatedId();
        dataModifier data = new dataModifier();
        ArrayList<String> orderID = data.readData(filepath,0);
        return orderID;
    }
    public ArrayList<String> readProductFile (int ID)  {
        dataModifier data = new dataModifier();
        String filepath = "src/Data/items.txt";
        return data.readDataByLine(filepath, ID);
    }
    public ArrayList<String> readProductID() {
        String filepath = "src/Data/items.txt";
        dataModifier data = new dataModifier();
        return data.readData(filepath, 0);
    }
    public Customer readCustomer() {

        String fullname;
        String phoneNum;
        String userName;
//        String passWord;

        String loginFile = "src/Data/LoginCustomer.txt";
        dataModifier data = new dataModifier();
        ArrayList<String> userNameList = data.readData(loginFile, 0);

        String username = userNameList.get(0);
        generatedId genID = new generatedId();

        String path = "src/Data/Customer.txt";
        ArrayList<String>  customerFullName = data.readData(path, 1);
//        ArrayList<String> customerPassWord = data.readData(path, 3);
        ArrayList<String> customerTel = data.readData(path, 4);
        ArrayList<String> customerUserName = data.readData(path, 2);

        Customer customer = null;
        for (int i =0; i < genID.idAdditioner(path); i++) {
            if(customerUserName.get(i).equals(username)) {
                fullname = customerFullName.get(i);
                phoneNum = customerTel.get(i);
                userName = customerUserName.get(i);
//                passWord = customerPassWord.get(i);
                customer = new Customer(fullname, userName, "", phoneNum);
                break;
            }
        }
        return customer;
    }

    public OrderMenu createOrderList()  {
        Date date = new Date();
        return new OrderMenu(orderList, date, readCustomer(),totalPaid);
    }
    public void addProduct() {
        System.out.println("Please enter the ID of the product you want to add: ");
        String productID = scan.next();
        ArrayList<String> productIDList = readProductID();
        boolean found = false;
        while (!found) {
            if (productIDList.contains(productID)) {
                found = true;
            } else {
                System.out.println("ProductID was not found, please try again: ");
                productID = scan.next();
            }
        }
        System.out.println("Please enter the quantity of the product: ");
        int quantity = scan.nextInt();
        String ID = productID.replace("ITM", "");
        ArrayList<String> productDetail = readProductFile(Integer.parseInt(ID));
        Product product = new Product(productDetail.get(1), Double.parseDouble(productDetail.get(2)), productDetail.get(3
        ));
        Order oder = new Order(product, quantity, quantity*product.getPrice());
        totalPaid = totalPaid + oder.getTotal();
        orderList.add(oder);
    }
    public String readLogin() {
        String loginFile = "src/Data/LoginCustomer.txt";
        String registerFile = "src/Data/Customer.txt";
        String clientID = "";

        dataModifier data = new dataModifier();
        ArrayList<String> userNameList = data.readData(loginFile, 0);

        String userName = userNameList.get(0);
        ArrayList<String> clientIDList = data.readData(registerFile, 0);
        ArrayList<String> clientUserName = data.readData(registerFile, 2);

        generatedId genID = new generatedId();
        for (int i = 0; i < genID.idAdditioner(registerFile); i++) {
            if (clientUserName.get(i).equals(userName)) {
                clientID = clientIDList.get(i);
            }

        }
        return clientID;

    }




}
