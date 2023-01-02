package Model;

public class Products {
    private String name;
    private double price;
    private String category;
    private String currency;

    public Products() {
        this.category = null;
        this.name = null;
        this.currency = null;
        this.price = 0;
    }

    public Products(String name, double price, String currency, String category) {
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", price=" + price + ", category='" + category + '\'' + ", currency='" + currency + '\'' +
                '}';
    }
}
