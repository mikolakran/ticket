package com.web.dao;

import com.web.entity.User;

import java.util.List;

public interface UserDAO extends DAO<User,Long> {
    User getByName(String name);
    User getByEmail(String email);
    List<User> getListUsers();
    List<User> getListDoctors();

}
