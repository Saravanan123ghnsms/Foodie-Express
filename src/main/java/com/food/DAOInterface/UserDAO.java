package com.food.DAOInterface;

import java.util.ArrayList;

import com.food.modelclass.UserPojo;

public interface UserDAO {
    int insertUser(UserPojo P);
    ArrayList<UserPojo> selectAll();
    UserPojo selectSpecific(String user_name);
    void update(String password,int user_id);
    void deleteUser(int user_id);
}
