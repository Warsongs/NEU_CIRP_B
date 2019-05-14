package com.sun.service;


import java.util.List;

public interface UserService {
    public int postUser(User user);

    public User getUserById(String id);

    public List<User> getUsersByCondition(UserExample example);

    public int putUser(User user);

    public int deleteUser(String id);

}
