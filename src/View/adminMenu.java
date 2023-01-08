package View;
import Controller.categoryModifier;
import Controller.changeModifier;
import Controller.productModifier;
import Model.Category;
import Model.Product;
import utility.displayData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import Controller.dataModifier;


public class adminMenu extends adminGoodsDisplay  {
    public void displayPanel()  {
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println(
            "1. Add new product\n" +
            "2. New product category added\n" +
            "3. Update data product\n" +
            "4. Display the available orders\n" +
            "5. Exit\n"
       );

        System.out.println(" Please enter your choice :");
        choice = scan.nextInt();
        switch(choice) {
            case 1 :
                addProduct();
                break;
            case 2 :
                addCategory();
                break;
            case 3 :
                updateProduct();
                break;
            case 4 :
                showAllOrders();
                break;
            case 5 :
                System.out.println(" Thanks for using our system !!!");
                break;
            default : System.out.println("Sorry, out of choice, please enter again your choice");

        }

    }


    @Override
    public void sortByPirce() {

    }

    @Override
    public void sortByCategory() {

    }


    /* ----- ADD PRODUCT CHOICE ------- */
    public void addProduct () throws IOException {
        boolean emerged = false;
        String categoryRoute = "src/Data/category.txt";
        dataModifier data = new dataModifier();
        ArrayList<String> categoryList  = data.readData(categoryRoute, 1);
        categoryList.remove(0);
        Scanner scan =  new Scanner(System.in);
        displayAllGoods();

        // Update product
        System.out.println("Please enter your product name : ");
        String productTitle = scan.nextLine();
        while(true) {
            productModifier pm = new productModifier();
            if (pm.uniqueValidator(productTitle.trim())) {
                System.out.println(" Sorry, you already have this product on your system . Please add other goods ");
                productTitle = scan.nextLine();
            } else {
                break;
            }
        }

        // Update prices
        System.out.println(" Please enter your product price");
        double productPrice = scan.nextDouble();
        scan.nextLine();
        System.out.println("Please choose your product category :");
        System.out.println("Show available categories in your system " + categoryList);
        String productCategory = scan.nextLine();
        while(true) {
                for (String cg : categoryList) {
                    if(cg.trim().equalsIgnoreCase(productCategory.trim())) {
                        emerged = true;
                        break;
                    }
                }

                if (!emerged) {
                    System.out.println("Unfortunately, seem likes you do not have this kind of category in your system. " +
                            " Please enter  '1' to undo action or '2' to add this category to the list ");
                    int choice  =  scan.nextInt();
                    switch (choice) {
                        case 1 :
                        {scan.nextLine();
                          System.out.println(" Enter your category again: ");
                          productCategory = scan.nextLine();
                        }
                        case 2 : addProduct();
                        default:
                            System.out.println("Wrong choices, please try again !!!");

                    }
                } else {
                    break;
                }
        }

        Product goods = new Product(productTitle, productPrice, productCategory);
        productModifier pm = new productModifier();
        pm.addProductTXT(goods);
        displayAllGoods();
        System.out.println(" 1. Continue to add " + "\t" +
                            "2. Quite to menu");

        System.out.println(" Please enter your choice :");
        int choice = scan.nextInt();
        switch(choice) {
            case 1:
                addProduct();
                break;
            case 2:
                displayPanel();
                break;
            default:
                System.out.println("Wrong choices, please try again !!!");
        }
    }


    /* ----- ADD CATEGORY CHOICE ------- */
    public void addCategory() throws IOException{
        String route = "src/Data/category.txt";
        dataModifier dm = new dataModifier();
        ArrayList<String> categoryList  =  dm.readData(route, 1);
        categoryList.remove(0);
        Scanner scan = new Scanner(System.in);
        categoryModifier cm = new categoryModifier();

        System.out.println(" Enter the category that you want to add: ");
        System.out.println(" Show available categories in your system \"" + categoryList);
        String nameOfCategory = scan.nextLine();
        while(true) {
            if (!cm.verifiableUniqueCategory(nameOfCategory)) {
                System.out.println("Sorry, you already have this category on your system . Please choose another : ");
                nameOfCategory = scan.nextLine();

            } else {
                break;
            }
        }

        Category category = new Category(nameOfCategory);
        cm.addCategoryTXT(category);
        System.out.println(" 1. Add another category" + "\t" +
                "2. Back to panel ");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                addCategory();
                break;
            case 2:
                displayPanel();
                break;
            default:
                System.out.println("Wrong choices, please try again !!!");

        }
    }


    /* ----- UPDATE PRODUCT CHOICES ------- */

    public void updateProduct()  {
        displayGoods();
        String itemRoute = "src/Data/items.txt";
        String categoryRoute = "src/Data/category.txt";
        HashMap <String, String> idProductMap = new HashMap<>();
        boolean emerged = false;
        boolean exist = true;

        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println(" Enter the id of product you want to modify : ");
        String id = scan.nextLine();
        dataModifier data = new dataModifier();

        ArrayList<String> productIdList = data. readData(itemRoute, 0);
        ArrayList<String> productTitleList = data.readData(itemRoute, 1);
        ArrayList<String> categoryList = data.readData(categoryRoute,1);
        categoryList.remove(0);

        for (int i = 0; i < productTitleList.size(); i++) {
            idProductMap.put(productIdList.get(i), productTitleList.get(i));
        }
        while(true) {
            for (String s: productTitleList) {
                if (!s.equals(id)) {
                    exist = false;
                } else {
                    exist = true;
                    break;
                }

            }

            if(!exist) {
                System.out.println(" The id is not appropriate . Please try again !");
                id = scan.nextLine();
            } else {
                break;
            }
        }

        // UPDATE NAME OF THE PRODUCT
        System.out.println(" Enter the updated name of your product, if you want to change it, retype it  ");
        String productTitle = scan.nextLine();
        while(true)
        {
            if  (Objects.equals(idProductMap.get(id).toLowerCase(), productTitle.trim().toLowerCase())) {
                break;
            }
            productModifier pm = new productModifier();
            if (pm.uniqueValidator(productTitle)) {
                System.out.println(" You already have this product. Please add another one  !");
                productTitle = scan.nextLine();
            } else {
                break;
            }
        }

        // UPDATE PRICE OF PRODUCT
        System.out.println("Please enter your product price: ");
        double productPrice = scan.nextDouble();
        scan.nextLine();

        System.out.println("Please enter your product category: ");
        System.out.println("Show available of categories : " + categoryList);
        String productCategory  = scan.nextLine();

        while (true) {
            for (String c : categoryList) {
                    if(c.trim().equalsIgnoreCase(productCategory.trim())) {
                        emerged = true;
                        break;
                    }
            }

            if (!emerged) {
                System.out.println(" You do not have this category. Please choose '1' to enter or  '2' to add it to the list: ");
                choice = scan.nextInt();
                switch (choice) {

                    case 1 :
                    {
                        scan.nextInt();
                        System.out.println(" Enter your category again ");
                        productCategory = scan.nextLine();
                    }

                    case 2:
                        addCategory();
                    default:
                        System.out.println("Invalid choice");
                }
            } else {
                break;

            }

        }

        Product goods = new Product(productTitle, productPrice, productCategory);
        changeModifier  cm = new changeModifier();
        cm.alterProductData(itemRoute, goods, id);
        displayAllGoods();
        displayPanel();

    }



    /* ----- DISPLAY ALL ORDERS FROM CUSTOMERS ------- */

    public void showAllOrders()  {
    displayData show = new displayData();
    show.displayGoods();
    adminOrderList  menu = new adminOrderList();
    menu.displayOrderMenu();

    }


    public void displayAllGoods() {
        new adminMenu().displayGoods();

    }
}
