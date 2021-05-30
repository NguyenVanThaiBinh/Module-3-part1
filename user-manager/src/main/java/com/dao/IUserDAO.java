package com.dao;

import com.model.User;

import java.util.List;

public interface IUserDAO {
    public  void insertUser(User user);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id);

    public boolean updateUser(User user);
}
