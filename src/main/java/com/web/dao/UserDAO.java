package com.web.dao;

import com.web.entity.User;

public interface UserDAO extends DAO<User,Long> {
    User getByName(String name);
    User getByEmail(String email);

}
