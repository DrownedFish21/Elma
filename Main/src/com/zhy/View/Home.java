package com.zhy.View;

import com.zhy.Service.impl.DishesService;
import com.zhy.Service.impl.UserService;
import com.zhy.Pojo.User;

import java.util.Scanner;

//首页
public class Home {
    public static void main(String[] args){

        int choice = 0;
        UserService us = new UserService();
        DishesService ds = new DishesService();
        Scanner scan = new Scanner(System.in);
        User loginedUser = new User();
        while (choice < 5) {
            System.out.print("""
                ————————————————————————
                1.登陆
                2.注册
                3.查看所有菜品信息
                4.点餐
                5.退出
                —————————————————————————
                """);
            System.out.println("=========================");
            System.out.println("请输入您的选择");
            System.out.println("=========================");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("您好，请登陆!");
                    System.out.println("输入手机号：");
                    String phone = scan.next();
                    System.out.println("输入密码：");
                    String passWord = scan.next();
                    loginedUser = us.login(phone,passWord);
                    break;
                case 2:
                    System.out.println("您好，请注册!");
                    if(us.register()){
                        System.out.println("注册成功！");
                    }
                    break;
                case 3:
                    System.out.println("查看所有菜品信息：\n");
                    System.out.println("=========================");
                    ds.ShowDishes(loginedUser);
                    break;
                case 4:
                    System.out.println("请点餐：\n");
                    ds.PurchaseDishes(loginedUser);
                    break;
                case 5:
                    System.out.println("欢迎您再次点餐");
                    break;
            }
        }
    }
}
