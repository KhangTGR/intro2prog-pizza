package View;
import Controller.changeModifier;
import utility.displayData;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class adminOrderList {
    public void displayOrderMenu () throws IOException {
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println (
             "1. View order by customer id \n" +
             "2. Change order's status \n" +
             "3. Back to the  main menu \n" +
                     "4. Exit \n"
        );

        System.out.println(" Please enter your choice :");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                orderByCustomer();
                break;
            case 2:
                changeOrderStatus();
                break;
            case 3:
                adminMenu menu = new adminMenu();
                menu.showAllOrders();
                break;
            case 4:
                System.out.println("Bye, see u again !!!");
                break;
            default:
                System.out.println(" Invalid choice, try again !!!");
        }

    }


    // CHECK EXISTED IF ORDER IS EXISTS OR NOT
    public boolean checkExistedId( String route, int index, String id) throws IOException {
        boolean existed = false;
        dataModifier dm = new dataModifier();
        ArrayList<String> list = dm.readData(route, index);
        for (String s: list) {
            if(s.equalsIgnoreCase(id.trim())) {
               existed = true;
               break;
            }
        }
        return existed;
    }


    // CHECK ORDERS FROM CUSTOMER
    public void orderByCustomer() throws IOException{
        String route = "src/Data/Orders.txt";
        displayData dd = new displayData();
        dd.displayGoods();
        Scanner scan = new Scanner(System.in);
        System.out.println("Typing id of the customer that you want to check ");
        String customerId = scan.nextLine();
        while (true) {
            if(checkExistedId(route,1, customerId)) {
                break;
            } else {
                System.out.println("This client id is not exist or they have not made any orders yet. Please choose another customers :");
                customerId = scan.nextLine();
            }
        }

    }


    public void changeOrderStatus() throws IOException {
        String route = "src/Data/Orders.txt";
        displayData dd = new displayData();
        dd.displayGoods();

        Scanner scan = new Scanner(System.in);
        System.out.println(" Please enter an order that you want to edit status of it");
        String orderId = scan.nextLine();
        while (true) {
            if(checkExistedId(route,0, orderId)) {
                break;
            } else {
                System.out.println("This Order id is not exist . Please choose another orders :");
                orderId = scan.nextLine();
            }
        }

        System.out.println("Please typing your new status :");
        String status = scan.nextLine();
        changeModifier change = new changeModifier();
        change.changeOrderStatus();
        dd.displayGoods();
        displayOrderMenu();


    }


}
