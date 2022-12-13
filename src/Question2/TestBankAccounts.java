/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Test 1
  Author: Pham Ngoc Huy
  ID: S3926681
  Created date: 3/12/2022
  Acknowledgement: Acknowledge the resources that you use here.
*/

package Question2;

public class TestBankAccounts {
    public static void main(String[] args) {
        // Test constructor and toString()
        Account account1 = new Account("s1001", "Tom Huynh", 100);
        System.out.println(account1); // toString();
        Account account2 = new Account("s1002", "Phong Ngo", 0); // default balance
        System.out.println(account2);
        // 0.2 means 20% interest rate
        SavingAccount account3 = new SavingAccount("s1003", "Robin Williams", 200, 0.2);
        System.out.println(account3);
        // Test Getters
        System.out.println("\nTesting Getter Methods:");
        System.out.println("ID: " + account1.getID());
        System.out.println("Name: " + account1.getName());
        System.out.println("Balance: " + account1.getBalance());
        // Test credit() and debit()
        System.out.println("\nCredit and Debit Testing:");
        account1.credit(100); // Add $100 to the balance
        System.out.println(account1);
        account1.debit(50); // Subtract $50 to the balance
        System.out.println(account1);
        account1.debit(500); // debit() error due to $500 exceeds balance
        System.out.println(account1); // The balance is unchanged
        // Test transfer amount between accounts
        System.out.println("\nTransfer Money Testing ($25):");
        account1.transferTo(account2, 25);
        System.out.println(account1);
        System.out.println(account2);
        // Test saving account
        System.out.println("\nSaving Account Testing (Calculate Interest Amount):");
        System.out.println(account3);
        account3.calculateInterestAmount(); // Add the interest amount (0.2*200) to the current balance
        System.out.println(account3);
    }
}
