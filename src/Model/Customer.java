package Model;

public class Customer {
    private String fullName;
    private String userName;
    private String passWord;
    private String phoneNum;

    public Customer() {
        this.fullName = null;
        this.userName = null;
        this.passWord = null;
        this.phoneNum = null;
    }
    public Customer(String fullName, String userName, String passWord, String phoneNum) {
        this.fullName = fullName;
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNum = phoneNum;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
