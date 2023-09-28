package com.zhy.Service;

import com.zhy.Pojo.User;

import java.io.IOException;

//用户相关逻辑操作
public interface IUserService {
   boolean register() throws IOException;
   User login(String userName, String passWord);

}
