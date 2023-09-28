package com.zhy.Dao.init;

import com.zhy.Pojo.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserInit {

    //加载用户到集合
    public static ArrayList<User> Load(){
        ArrayList<User> userArrayList = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        String pathname = "DatabaseFile\\user.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                arrayList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        HashMap<String,String> userMap = new HashMap<>();
        for (String m : arrayList) {
            String string1 = m.split("\\{")[1].split("}")[0];
            String[] split = string1.split(",");
            for (String string : split) {
                String[] s1 = string.split("=");
                userMap.put(s1[0], s1[1]);
            }
            userArrayList.add(new User(Integer.parseInt(userMap.get("uid")),
                    userMap.get("userName"),
                    userMap.get("passWord"),
                    Integer.parseInt(userMap.get("age")),
                    userMap.get("phone"),
                    Double.parseDouble(userMap.get("price"))));
        }
        return userArrayList;
    }
}
