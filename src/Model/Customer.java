package Model;

public class Customer {
    private String name;
    private String phone;
    private String userName;
    private String password;

    public Customer(){
        this.name = null;
        this.phone = null;
        this.userName = null;
        this.password = null;
    }

    public Customer(String name, String phone, String userName, String password) {
        this.name = name;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return "Customer.Customer{" +
                "fullName is'" + name + '\'' +
                ", phoneNum='" + phone + '\'' +
                ", userName is'" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
