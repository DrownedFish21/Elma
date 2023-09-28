package com.zhy.Dao;

import com.zhy.Dao.init.DishesInit;
import com.zhy.Pojo.Dishes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class DishesDao {
    static ArrayList<Dishes> dishesArrayList;
    static {
        dishesArrayList = DishesInit.init();
    }

    //获取菜单
    public ArrayList<Dishes> getDishes(){
        return dishesArrayList;
    }

    //修改菜单
    public void setDishes(ArrayList<Dishes> arrayList){

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("DatabaseFile\\Dishes.txt"));
            for (Dishes dishes : arrayList) {
                br.write(dishes.toMenuString());
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
