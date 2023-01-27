package com.web.dao.impl;

import com.web.entity.User;
import com.web.exception.LoginException;
import com.web.exception.MyException;
import com.web.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.web.dao.UserDAO;

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
    public User getByName(String name) {
        return userJpaRepository.findByUserName(name);
    }

    @Override
    public User getByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }

    private void validationSQL(User user) throws MyException {
        if (getByName(user.getUserName()) != null) {
            log.error("UserDAOImpl.validationSQL(User user)",
                    new Throwable("user.getUserName() != null = " + user));
            throw new LoginException("name exist");
        } else {
            log.trace("UserDAOImpl.save(User user) = true");
        }
        if (getByEmail(user.getEmail()) != null) {
            log.error("UserDAOImpl.validationSQL(User user)",
                    new Throwable("user.getEmail() != null = " + user));
            throw new LoginException("email exist");
        } else {
            log.trace("UserDAOImpl.save(User user) = true");
        }
    }
}
