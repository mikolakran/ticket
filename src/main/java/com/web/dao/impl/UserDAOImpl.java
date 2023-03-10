package com.web.dao.impl;

import com.web.entity.User;
import com.web.exception.LoginException;
import com.web.exception.MyException;
import com.web.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.web.dao.UserDAO;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserJpaRepository userJpaRepository;


    @Override
    public User save(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public User get(Long aLong) {
        return userJpaRepository.findById(aLong).orElse(null);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long aLong) {
        userJpaRepository.deleteById(aLong);
    }

    @Override
    public User findByName(String name) {
        return userJpaRepository.findByUserName(name);
    }

    @Override
    public User findByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }

    @Override
    public List<User> findListUsers() {
        return userJpaRepository.findByRole("user");
    }

    @Override
    public List<User> findListDoctors() {
        return userJpaRepository.findByRole("doctor");
    }

    private void validationSQL(User user) throws MyException {
        if (findByName(user.getUserName()) != null) {
            throw new LoginException("name exist");
        }
        if (findByEmail(user.getEmail()) != null) {
            throw new LoginException("email exist");
        }
    }
}
