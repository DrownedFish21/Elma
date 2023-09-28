package com.zhy.Dao;

import com.zhy.Dao.init.UserInit;
import com.zhy.Pojo.User;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


//用户数据操作
public class UserDao {
    private static final int userNum;

    static ArrayList<User> userArrayList;
    static {
        userArrayList = UserInit.Load();
        userNum = userArrayList.size();
    }

    //查询当前用户总数
    public int getUserNum(){
        return userNum;
    }
    //获取所有用户
    public ArrayList<User> getUserArrayList(){
        return userArrayList;
    }

    //增加用户
    public void addUser(User user){
        try {

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream("DatabaseFile\\user.txt",true)));
            String str = user.toString();
            writer.write(str+"\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        userArrayList = UserInit.Load();
    }

    //查询用户
    public User selectUser(String phone){
        for (User user : userArrayList) {
            if (user.getPhone().equals(phone)) {
                return user;
            }
        }
        return null;
    }


}
