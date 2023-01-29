package com.web.facades;

import com.web.dao.PositionDoctorDAO;
import com.web.entity.Doctor;
import com.web.entity.PositionDoctor;
import com.web.exception.MyException;
import com.web.forms.DoctorForm;
import com.web.forms.PositionDoctorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PositionDoctorFacade {
    @Autowired
    private PositionDoctorDAO positionDoctorDAO;

    public PositionDoctorForm save(PositionDoctorForm positionDoctorForm) throws MyException {
        PositionDoctor positionDoctor = new PositionDoctor();
        buildPosition(positionDoctor,positionDoctorForm);
        PositionDoctor resultSave = positionDoctorDAO.save(positionDoctor);
        return new PositionDoctorForm(resultSave);
    }

    public void update(PositionDoctorForm positionDoctorForm){
        PositionDoctor positionDoctor = new PositionDoctor();
        buildPosition(positionDoctor,positionDoctorForm);
        positionDoctorDAO.update(positionDoctor);
    }

    public PositionDoctorForm findByName(PositionDoctorForm positionDoctorForm){
        PositionDoctor positionDoctor = new PositionDoctor();
        buildPosition(positionDoctor,positionDoctorForm);
        PositionDoctor resultByName = positionDoctorDAO.findByPosition(positionDoctor.getPosition());
        return new PositionDoctorForm(resultByName);
    }

    public List<PositionDoctorForm> findAll() {
        List<PositionDoctorForm> positionDoctorForms = new ArrayList<>();
        positionDoctorDAO.findAll().forEach(positionDoctor -> positionDoctorForms.add(new PositionDoctorForm(positionDoctor)));
        return positionDoctorForms;
    }

    public Set<DoctorForm> getListDoctor(long idPosition) {
        Set<DoctorForm> doctorForms = new HashSet<>();
        Set<Doctor> listUser = positionDoctorDAO.getListDoctor(idPosition);
        listUser.forEach(doctor -> {
            DoctorForm doctorForm = new DoctorForm(doctor);
            doctorForms.add(doctorForm);
        });
        return doctorForms;
    }

    private void buildPosition(PositionDoctor positionDoctor ,PositionDoctorForm positionDoctorForm) {
        positionDoctor.setPositionDoctorId(positionDoctorForm.getPositionDoctorId());
        positionDoctor.setPosition(positionDoctorForm.getPosition());
        positionDoctor.setBeginningWork(positionDoctorForm.getBeginningWork());
        positionDoctor.setBeginningBreak(positionDoctorForm.getBeginningBreak());
        positionDoctor.setEndBreak(positionDoctorForm.getEndBreak());
        positionDoctor.setEndWork(positionDoctorForm.getEndWork());
        Set<Doctor> doctors = new HashSet<>();
        if (positionDoctorForm.getDoctors()!=null) {
            positionDoctorForm.getDoctors().forEach(doctorForm -> {
                Doctor doctor = new Doctor(doctorForm.getIdDoctor(),doctorForm.getCabinetNumber(),
                        doctorForm.getSpecialityDoctor());
                doctors.add(doctor);
                positionDoctor.setDoctors(doctors);
            });
        }
    }
}
