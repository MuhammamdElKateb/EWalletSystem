package Model;

public class Account {
    String name;
    String password;
    int age;
    String phoneNumber;
    double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String name, String password, int age, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = 0;

    }
    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public Account() {

    }
}


