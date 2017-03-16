package com.feng.dao;

import com.feng.entity.User;

public interface UserDao {
  public User findById(int id);
  public User findByName(String userName);
}
