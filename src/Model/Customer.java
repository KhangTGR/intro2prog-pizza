package Model;

public class Customer {
    private String fullName;
    private String username;
    private String passWord;
    private String phoneNumber;

    public Customer(String fullName, String username, String passWord, String phoneNumber) {
        this.fullName = fullName;
        this.username = username;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
