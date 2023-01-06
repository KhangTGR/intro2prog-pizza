package Model;

public class Order {
    private Products products;
    private int quantity;
    private double total;
    public Order() {
        this.products = null;
        this.quantity = 0;
        this.total = 0.0;
    }
    public Order(Products products, int quantity, double total) {
        this.products = products;
        this.quantity = quantity;
        this.total = total;
    }

    public Products getProducts() {
        return products;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
