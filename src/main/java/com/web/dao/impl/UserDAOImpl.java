package com.web.dao.impl;

import com.web.entity.User;
import com.web.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.web.dao.UserDAO;


import java.util.List;
import java.util.Set;

@Repository
@Slf4j
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserJpaRepository userJpaRepository;


    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public User get(Long aLong) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public User getByName(String name) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getListUsers() {
        return null;
    }

    @Override
    public Set<User> getListUsersWhereIdTopic(long id) {
        return null;
    }

    @Override
    public String getRole(User user) {
        return null;
    }
}
