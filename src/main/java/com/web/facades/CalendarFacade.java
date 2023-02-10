package com.web.facades;

import com.web.dao.CalendarDAO;
import com.web.entity.Calendar;
import com.web.entity.Doctor;
import com.web.forms.CalendarForm;
import com.web.forms.DoctorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class CalendarFacade {

    @Autowired
    private CalendarDAO calendarDAO;

    public CalendarForm save(CalendarForm calendarForm){
        Calendar calendar = new Calendar();
        buildUser(calendar, calendarForm);
        Calendar resultSave = calendarDAO.save(calendar);
        return new CalendarForm(resultSave);
    }

    public CalendarForm findLocalDate(LocalDate localDate){
        System.out.println(localDate.toString());
        Calendar calendar = calendarDAO.findLocalDate(localDate);
        return new CalendarForm(calendar);
    }

    public Set<DoctorForm> findListDoctor(LocalDate localDate) {
        Set<DoctorForm> doctorForms = new HashSet<>();
        Set<Doctor> doctors = calendarDAO.findListDoctor(localDate);
        if (doctors!=null) {
            doctors.forEach(doctor -> {
                DoctorForm doctorForm = new DoctorForm(doctor);
                doctorForms.add(doctorForm);
            });
        }
        return doctorForms;
    }

    public CalendarForm findByMaxLocalDate(){
        Calendar byMaxLocalDate = calendarDAO.findByMaxLocalDate();
        return new CalendarForm(byMaxLocalDate);
    }

    private void buildUser(Calendar calendar, CalendarForm calendarForm){
        calendar.setIdDate(calendarForm.getIdDate());
        calendar.setLocalDate(calendarForm.getLocalDate());
        Set<Doctor> listDoctor = new HashSet<>();
        Set<DoctorForm> doctors = calendarForm.getDoctors();
        if (doctors!=null) {
            doctors.forEach(doctorForm -> {
                Doctor doctor = new Doctor(doctorForm);
                listDoctor.add(doctor);
            });
            calendar.setDoctors(listDoctor);
        }
    }
}
