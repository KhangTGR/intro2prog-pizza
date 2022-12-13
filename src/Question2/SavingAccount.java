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

public class SavingAccount extends Account {
    // Attributes
    private double savingInterestRate;
    // Constructors with 'balance' attribute
    public SavingAccount(String id, String name, double balance, double savingInterestRate) {
        super(id, name, balance);
        this.savingInterestRate = savingInterestRate;
    }

    // Getter getSavingInterestRate
    public double getSavingInterestRate() {
        return savingInterestRate;
    }

    // Setter setSavingInterestRate
    public void setSavingInterestRate(double savingInterestRate) {
        this.savingInterestRate = savingInterestRate;
        System.out.println("Set saving interest rate successful");
    }

    // return SavingAccount
    @Override
    public String toString() {
        return "SavingAccount: " +
                "id=" + super.getID() + ", " +
                "name=" + super.getName() + ", " +
                "balance=" + super.getBalance() + ", " +
                "savingInterestRate=" + savingInterestRate;
    }

    // method of calculateInterestAmount
    public void calculateInterestAmount() {
        double steady = super.getBalance();
        double newCurrentBalance = steady + (steady * savingInterestRate);
        super.setBalance(newCurrentBalance);
        System.out.println("Calculate interest balance successful");
    }
}