package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.dataModifier;
import Controller.orderModifier;
import Controller.changeModifier;
import utility.displayData;



public class CustomerMenu {

    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("CUSTOMER MENU");
        System.out.println("1. View your account information\n2. View all products\n3. Search for available products\n4. Filter products by price\n5. Order product\n6. Exit");
        System.out.println("Please enter your option: ");
        int option = scan.nextInt();
        switch (option) {
            case 1:
                String path = "src/Data/Customer.txt";
                String username = readUserName();
                orderModifier oM = new orderModifier();
                changeModifier cM = new changeModifier();
                if(oM.getTotalUse() >= 6000 && oM.getTotalUse() < 12000 ) {
                    cM.changeCustomerRank("Silver", path, oM.readLogIn());
                } else if(oM.getTotalUse() >=12000 && oM.getTotalUse() < 18000) {
                    cM.changeCustomerRank("Gold", path, oM.readLogIn());
                } else if(oM.getTotalUse() >=18000 && oM.getTotalUse() < 24000) {
                    cM.changeCustomerRank("Diamond", path, oM.readLogIn());
                }
                displayData DisplayData = new displayData();
                DisplayData.displayClientInformation(username);
                displayMenu();
                break;
            case 2:
                displayData displayItems = new displayData();
                displayItems.displayGoods();
                displayMenu();
                break;
            case 3:
                filterCategory();
                displayMenu();
                break;
            case 4:
                displayData filterPrice = new displayData();
                System.out.println("Available products");
                filterPrice.displayGoods();
                System.out.println("Please enter minimum price: ");
                double minPrice = scan.nextDouble();
                System.out.println("Please enter maximum price: ");
                double maxPrice = scan.nextDouble();
                filterPrice.sortPrice(minPrice, maxPrice);
                displayMenu();





        }
    }
    public String readUserName() {
        String filepath = "src/Data/LoginCustomer.txt";
        dataModifier dm = new dataModifier();
        ArrayList<String> userNameList = dm.readData(filepath, 0);
        return userNameList.get(0);

    }
    public void filterCategory() {
        String filepath = "src/Data/Category.txt";
        Scanner scan = new Scanner(System.in);
        displayData filterCategory = new displayData();
        dataModifier dM = new dataModifier();
        ArrayList<String> categories = dM.readData(filepath, 1);
        categories.remove(0);
        System.out.println("Please enter the product category you want to search: ");
        System.out.println(categories);
        String category = scan.nextLine();
        boolean found = true;
        while (!found) {
            if (!categories.contains(category)) {
                System.out.println("No category was found, please enter again: ");
                category = scan.nextLine();
            } else {
                found = true;
                for (String productType: categories) {
                    if(category.equals(productType)) {
                        filterCategory.sortCategory(category);
                    }
                }
            }
        }
    }

}
