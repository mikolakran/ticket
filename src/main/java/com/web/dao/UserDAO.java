package com.web.dao;

import com.web.entity.User;

import java.util.List;

public interface UserDAO extends DAO<User,Long> {
    User findByName(String name);
    User findByEmail(String email);
    List<User> findListUsers();
    List<User> findListDoctors();

}
