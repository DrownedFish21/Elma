package com.zhy.Service.impl;

import com.zhy.Service.IUserService;
import com.zhy.Dao.UserDao;
import com.zhy.Pojo.User;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService implements IUserService {
    UserDao userDao = new UserDao();
    ArrayList<User> userArrayList = userDao.getUserArrayList();
    @Override
    public boolean register() {
        int userNum = userDao.getUserNum();
        Scanner scan = new Scanner(System.in);
        String userName,passWord,phone;
        int age;
        System.out.println("请输入昵称：");
        userName =scan.next();
        System.out.println("请输入密码：");
        passWord =scan.next();
        System.out.println("请输入年龄：");
        age =scan.nextInt();
        System.out.println("请输入手机号：");
        phone =scan.next();
        for (User user : userArrayList) {
            if(user.getPhone().equals(phone)){
                System.out.println("用户已注册！");
                return false;
            }
        }
        User user = new User(++userNum,userName,passWord,age,phone,0);
        userDao.addUser(user);
        return true;
    }

    @Override
    public User login(String phone, String passWord) {
        User user = userDao.selectUser(phone);
        if(user==null){
            System.out.println("未找到用户,请注册！");
        }
        else {
            if (user.getPassWord().equals(passWord)) {
                System.out.println("登陆成功！");
            }
            else {
                System.out.println("密码错误！");
            }
        }
        return user;
    }
    //修改用户余额
    public void setPrice(User user,double price){
        try {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream("DatabaseFile\\user.txt")));
            for (User user1 : userArrayList) {
                if(user1.getUid()==user.getUid()){
                    user1.setPrice(price);
                }
                writer.write(user1+"\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
