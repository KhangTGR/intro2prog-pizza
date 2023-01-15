package Model;

public class Order {

    private Product product;
    private int quantity;
    private double total;



    public Order(Product product, int quantity, double total) {

        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }


    public Product getProduct() {
        return product;
    }


    public void setProduct(Product product) {
        this.product = product;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {

        return "Order {" +
                "product =" + product + ", total =" + total + ", quantity =" + quantity + ", totalPrice =" + total +

                '}';
    }

}
