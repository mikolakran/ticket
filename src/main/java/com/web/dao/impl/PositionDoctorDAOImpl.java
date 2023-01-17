package com.web.dao.impl;

import com.web.dao.PositionDoctorDAO;
import com.web.entity.PositionDoctor;
import com.web.repository.PositionDoctorJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Slf4j
public class PositionDoctorDAOImpl implements PositionDoctorDAO {

    @Autowired
    private PositionDoctorJpaRepository positionDoctorJpaRepository;

    @Override
    public PositionDoctor save(PositionDoctor positionDoctor) {
        return positionDoctorJpaRepository.save(positionDoctor);
    }

    @Override
    public PositionDoctor get(Long aLong) {
        return null;
    }

    @Override
    public void update(PositionDoctor positionDoctor) {

    }

    @Override
    public void delete(Long aLong) {

    }
}
