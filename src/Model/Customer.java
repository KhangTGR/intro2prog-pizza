package Model;

public class Customer {

    private String fullName;
    private String phoneNumber;
    private String userName;
    private String Password;

    public Customer() {
        this.fullName = null;
        this.phoneNumber = null;
        this.userName = null;
        this.Password = null;

    }

    public Customer(String fullName, String phoneNumber, String userName, String Password) {}  {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.Password = Password;
    }


    public String getFullName() {
        return fullName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return Password;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "full name = " + fullName + "," +
                "phone number = " + phoneNumber + "," +
                "user name = " + userName + "," +
                "password = " + Password +
                '}';



    }

}
