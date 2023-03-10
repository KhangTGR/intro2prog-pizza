package Model;

import java.util.ArrayList;
import java.util.Date;

public class OrderMenu {
    private ArrayList<Order> orders;
    private Date date;
    private Customer customer;
    private double total;


    public OrderMenu( ArrayList<Order> orders, Date date, Customer customer, double total) {
        this.orders = orders;
        this.date = date;
        this.customer = customer;
        this.total = total;

    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Date getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {

        return "OrderMenu {" +
        "orders = " + orders + ", date= " + date + ", customer= " + customer + ", total= " + total + '}';
    }
}
