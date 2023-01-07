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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
