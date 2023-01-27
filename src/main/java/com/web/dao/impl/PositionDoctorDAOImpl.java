package com.web.dao.impl;

import com.web.dao.PositionDoctorDAO;
import com.web.entity.Doctor;
import com.web.entity.PositionDoctor;
import com.web.repository.PositionDoctorJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


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
        positionDoctorJpaRepository.save(positionDoctor);
    }

    @Override
    public void delete(Long aLong) {

    }


    @Override
    public List<PositionDoctor> findAll() {
        return positionDoctorJpaRepository.findAll();
    }

    @Override
    public PositionDoctor findByPosition(String name) {
        return positionDoctorJpaRepository.findByPosition(name);
    }

/*    @Override
    public Set<User> getListUser(long id) {
        return positionDoctorJpaRepository.getListUser(id).getUsers();
    }*/

    @Override
    public Set<Doctor> getListDoctor(long id) {
        return positionDoctorJpaRepository.getListDoctor(id).getDoctors();
    }


}
