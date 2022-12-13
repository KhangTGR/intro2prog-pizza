/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Test 1
  Author: Pham Ngoc Huy
  ID: S3926681
  Created date: 12/03/2022
  Acknowledgement: Acknowledge the resources that you use here.
*/

package Question2;

public class Account {
    // Attribute
    private String id;
    private String name;
    private Double balance;
    // Constructor with 'balance' attribute
    public Account(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        if (balance > 0.0) // if the balance is valid
            this.balance = balance; // assign it to instance variable balance
        else { // if the balance is not valid
            this.balance = 0.0; // assign it to zero balance
        }
    }
    // Constructor
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }
    // Get attributes 'id'
    public String getID() {
        return id;
    }
    // Set attributes 'id'
    public void setID(String id) {
        this.id = id;
        System.out.println("Set id successful");
    }
    // Get attributes 'name'
    public String getName() {
        return name;
    }
    // Set attributes 'name'
    public void setName(String name) {
        this.name = name;
        System.out.println("Set name successful");
    }
    // Get attributes 'balance'
    public double getBalance() {
        return this.balance;
    }
    // Set attributes 'balance'
    public void setBalance(Double balance) {
        this.balance = balance;
        System.out.println("Set balance successful");
    }

    // 'credit' method
    public void credit(double amount) {
        this.balance = balance +  amount; // Add  amount
        System.out.println("Credit successful");
    }
    // 'debit' method
    public void debit(double amount) {
        if (this.balance >= amount)
            this.balance = balance - amount; // Decrease  amount
        else
            System.out.println("The debit amount is larger than the balance!");
        System.out.println("Debit successful");
    }
    // Money transfer method
    public void transferTo(Account anotherAccount, double amount) {
        anotherAccount.balance = balance + amount;
        this.balance = balance - amount;
        System.out.println("Transferring successful");
    }
    // return the Account
    @Override
    public String toString() {
        return "Account: " +
                "id='" + id + '\'' + ", " +
                "name='" + name + '\'' + ", " +
                "balance=" + balance;
    }

}
