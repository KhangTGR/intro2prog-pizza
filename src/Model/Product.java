package Model;

public class Product {
    private String title;
    private double price;
    private String category;


    public Product() {

        this.category = null;
        this.title = null;
        this.price = 0;

    }

    public Product (String title, double price, String category) {
        this.title = title;
        this.price = price;
        this.category = category;


    }


    public String getTitle() {
        return title;
    }


    public double getPrice() {
        return price;
    }



    public String getCategory() {
        return category;
    }







    @Override
    public String toString() {
        return "Product {" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';


    }

}
