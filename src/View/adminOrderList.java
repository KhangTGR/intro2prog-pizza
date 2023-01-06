package View;
import Controller.changeModifier;
import Controller.dataModifier;
import utility.displayData;


import java.util.ArrayList;
import java.util.Scanner;

public class adminOrderList {
    public void displayOrderMenu () {
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
    public boolean checkExistedId( String route, int index, String id) {
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
    public void orderByCustomer() {
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


    public void changeOrderStatus() {
        String route = "src/Data/Orders.txt";


    }


}
