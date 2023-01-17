package com.web.dao.impl;

import com.web.repository.PassportJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.web.dao.PassportDAO;
import com.web.entity.Passport;

@Repository
@Slf4j
public class PassportDAOImpl implements PassportDAO {

    @Autowired
    private PassportJpaRepository passportJpaRepository;

    @Override
    public Passport save(Passport passport) {
        return passportJpaRepository.save(passport);
    }

    @Override
    public Passport get(Long aLong) {
        return null;
    }

    @Override
    public void update(Passport passport) {

    }

    @Override
    public void delete(Long aLong) {

    }
}
