package View;

import Model.Customer;
import Model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.Product;
import utility.displayData;
import utility.generatedId;
import Controller.dataModifier;
import Model.OrderMenu;
import Controller.orderModifier;

public class CustomerOrderMenu extends CustomerMenu{
    ArrayList<Order> orderList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    double totalPaid = 0;
    public void displayOrderMenu() {
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
                    if(decision.equals("Yes")) {
                        System.out.println("Order sucessfully");
                        orderModifier om = new orderModifier();
                        om.addOrdertxt(createOrderList());
                        displayOrderMenu();
                        break;
                    }else {
                        addProduct();
                    }
                }
                break;
        }

    }
        public ArrayList<String> readOrderID() {
            String filepath = "src/Data/Order.csv";
            generatedId lineCount = new generatedId();
            dataModifier data = new dataModifier();
            ArrayList<String> orderID = data.readData(filepath, 0);
            return orderID;
        }
        public ArrayList<String> readProductFile (int ID) {
            dataModifier data = new dataModifier();
            String filepath = "src/Data/Items.csv";
            return data.readDataByLines(filepath, ID);
        }
        public ArrayList<String> readProductID() {
            String filepath = "src/Data?Items.csv";
            dataModifier data = new dataModifier();
            return data.readData(filepath, 0);
        }
        public Customer readCustomer() {
            String loginFile = "src/Data/LoginCustomer.txt";
            String fullname;
            String phoneNum;
            String userName;
            dataModifier data = new dataModifier();
            ArrayList<String> userNameList = data.readData(loginFile, 0);
            String username = userNameList.get(0);
            generatedId genID = new generatedId();
            String path = "src/Data/Customer.txt";
            ArrayList<String>  customerFullName = data.readData(path, 1);
            ArrayList<String> customerTel = data.readData(path, 4);
            ArrayList<String> customerUserName = data.readData(path, 2);
            Customer customer = null;
            for (int i =0; i < genID.idAdditioner(path); i++) {
                if(customerUserName.equals(username)) {
                    fullname = customerFullName.get(i);
                    phoneNum = customerTel.get(i);
                    userName = customerUserName.get(i);
                    customer = new Customer(fullname, userName, "", phoneNum);
                    break;
                }
            }
            return customer;
        }
        public OrderMenu createOrderList() {
            Date date = new Date();
            return new OrderMenu(orderList, date, readCustomer(), totalPaid);
        }
        public void addProduct() {
            System.out.println("Please enter the ID of the product you want to add: ");
            String productID = scan.next();
            ArrayList<String> productIDList = readProductID();
            boolean found = false;
            while (!found) {
                if (productIDList.contains(productID)) {
                    found = true;
                }else {
                    System.out.println("ProductID was not found, please try again: ");
                    productID = scan.next();
                }
            }
            System.out.println("Please enter the quantity of the product: ");
            int quantity = scan.nextInt();
            String ID = productID.replace("ITM", "");
            ArrayList<String> productDetail = readProductFile(Integer.parseInt(ID));
            Product product = new Product(productDetail.get(1), Double.parseDouble(productDetail.get(2)), productDetail.get(3) );
            Order oder = new Order(product, quantity, quantity*product.getPrice());
            totalPaid = totalPaid + oder.getTotal();
            orderList.add(oder);
        }



}
