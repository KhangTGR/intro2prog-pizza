package Customer;

public class Product_order {
        private Products product;
        private int amount;
        private double total;
        public Product_order() {
            this.product = null;
            this.amount = 0;
            this.total = 0;
        }
        public Product_order(Products product, int quantity, double total) {
            this.product = product;
            this.amount = quantity;
            this.total = total;
        }
        public Products getProduct() {
            return product;
        }
        public void setProduct(Products product) {
            this.product = product;
        }
        public int getQuantity() {
            return amount;
        }
        public void setQuantity(int quantity) {
            this.amount = quantity;
        }
        public double getTotal() {
            return total;
        }
        public void setTotal(double total) {
            this.total = total;
        }
        @Override
        public String toString() {
            return "Order{" + "product=" + product + ", quantity=" + amount + ", total=" + total + '}';
        }
}
