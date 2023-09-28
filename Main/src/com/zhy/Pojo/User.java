package com.zhy.Pojo;

public class User {
    private int uid;
    private String userName;
    private String passWord;
    private int age;
    private String phone;
    private double price;

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ",userName=" + userName  +
                ",passWord=" + passWord  +
                ",age=" + age +
                ",phone=" + phone +
                ",price=" + price +
                '}';
    }

    public User(int uid, String userName, String passWord, int age, String phone, double price) {
        this.uid = uid;
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.phone = phone;
        this.price = price;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
