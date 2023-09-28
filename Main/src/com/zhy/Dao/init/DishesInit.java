package com.zhy.Dao.init;

import com.zhy.Pojo.Dishes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DishesInit {

    //菜品初始化
    public static ArrayList<Dishes> init(){
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Dishes> dishesArrayList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("DatabaseFile\\Dishes.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                arrayList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String s : arrayList) {
            String[] split = s.split(",");
            dishesArrayList.add(new Dishes(
                    Integer.parseInt(split[0]),
                    split[1],
                    split[2],
                    Integer.parseInt(split[3]),
                    Integer.parseInt(split[4]),
                    Double.parseDouble(split[5]))
            );
        }
        return dishesArrayList;
    }

}
