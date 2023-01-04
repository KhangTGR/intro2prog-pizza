package Model;

public class Product {

    private String title;
    private double price;
    private String category;
    private String currency;

    public Product() {

        this.category = null;
        this.title = null;
        this.price = 0;
        this.currency = null;
    }

    public Product (String title, double price, String category, String currency) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.currency = currency;

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



    public String getCurrency() {
        return currency;
    }



@Override
    public String toString() {
    return "Product {" +
            "title='" + title + '\'' +
            ", price=" + price +
            ", category='" + category + '\'' +
            ", currency='" + currency + '\'' +
            '}';


}

}
