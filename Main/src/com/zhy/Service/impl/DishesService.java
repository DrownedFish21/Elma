package com.zhy.Service.impl;

import com.zhy.Pojo.Dishes;
import com.zhy.Service.IDishesService;
import com.zhy.Dao.DishesDao;
import com.zhy.Pojo.User;
import java.util.ArrayList;
import java.util.Scanner;

public class DishesService implements IDishesService {
    DishesDao dishesDao = new DishesDao();
    UserService userService = new UserService();
    ArrayList<Dishes> dishesArrayList = dishesDao.getDishes();

    //展示菜品
    @Override
    public void ShowDishes(User user) {
        if(user.getUid() == 0){
            System.out.println("请登陆后查看菜系！");
            return;
        }
        dishesArrayList.forEach(System.out::println);
    }

    //购买并打印信息
    @Override
    public void PurchaseDishes(User user) {

        if(user.getUid() == 0){
            System.out.println("请先登陆再买饭！");
            return;
        }
        String dishName = "";
        double dishPrice = 0;
        double cost = 0;
        double money = user.getPrice();
        String userName = user.getUserName();
        dishesArrayList.forEach(System.out::println);
        System.out.println("请选择您要购买菜品所在的序号：");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        System.out.println("请输入您要购买的数量：");
        int purchaseNum = scan.nextInt();
        int num = 0;
        for (int i = 0; i < dishesArrayList.size(); i++) {
            Dishes dishes = dishesArrayList.get(i);
            if(dishes.getDid()==choice){
                if(user.getPrice() < dishes.getPrice()){
                    System.out.println("您的余额不足，请及时缴费！");
                    return;
                }
                dishName = dishes.getDname();
                dishPrice = dishes.getPrice();
                cost = purchaseNum * dishes.getPrice();
                money = user.getPrice() - purchaseNum * dishes.getPrice();
                dishes.setCount(dishes.getCount()+purchaseNum);
                dishes.setNum(dishes.getNum()-purchaseNum);
                user.setPrice(money);

                //同步用户信息
                dishesArrayList.set(i,dishes);
                dishesDao.setDishes(dishesArrayList);
                userService.setPrice(user,money);
            }
            else {
                num++;
            }
        }
        if(num == dishesArrayList.size()){
            System.out.println("请输入正确的菜品序号");
            return;
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(
                userName+"先生，您已购买我店"+dishName+"*"+purchaseNum+"\n"
                        +"单价："+dishPrice+"\n"
                        +"共花费" + cost + "元;\n"
                        +"您的账户余额为："+money+"元;"
        );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if (money < 0) {
            System.out.println("您已欠费，请及时交费！");
        }
    }
}
