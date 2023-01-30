package com.web.facades;

import com.web.dao.CalendarDAO;
import com.web.entity.Calendar;
import com.web.entity.Doctor;
import com.web.entity.Passport;
import com.web.exception.MyException;
import com.web.forms.CalendarForm;
import com.web.forms.DoctorForm;
import com.web.forms.PassportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CalendarFacade {

    @Autowired
    private CalendarDAO calendarDAO;

    public CalendarForm save(CalendarForm calendarForm) throws MyException {
        Calendar calendar = new Calendar();
        buildUser(calendar, calendarForm);
        Calendar resultSave = calendarDAO.save(calendar);
        return new CalendarForm(resultSave);
    }

    public Set<CalendarForm> findAll(){
        Set<CalendarForm> calendarForms = new HashSet<>();
        calendarDAO.findAll().forEach(calendarTicket -> calendarForms.add(new CalendarForm(calendarTicket)));
        return calendarForms;
    }

    public CalendarForm findId(long idDate){
        Calendar calendar = calendarDAO.get(idDate);
        return new CalendarForm(calendar);
    }

    public Set<PassportForm> getListPassport(long idDate) {
        Set<PassportForm> passportForms = new HashSet<>();
        Set<Passport> listPassport = calendarDAO.getListPassport(idDate);
        listPassport.forEach(passport -> {
            PassportForm passportForm = new PassportForm(passport);
            passportForms.add(passportForm);
        });
        return passportForms;
    }

    public List<CalendarForm> findByDoctor_IdDoctor(long idDoctor, int pageNo, int pageSize){
       Pageable pageable = PageRequest.of(pageNo,pageSize);
       List<CalendarForm> calendarForms = new ArrayList<>();
        List<Calendar> byDoctor_idDoctor = calendarDAO.findByDoctor_IdDoctor(idDoctor, pageable);
        byDoctor_idDoctor.forEach(calendarTicket -> {
            CalendarForm calendarForm = new CalendarForm(calendarTicket);
            calendarForms.add(calendarForm);
        });
        return calendarForms;
    }

    private void buildUser(Calendar calendar, CalendarForm calendarForm){
        calendar.setIdDate(calendarForm.getIdDate());
        calendar.setLocalDate(calendarForm.getLocalDate());
        calendar.setTime8_30(calendarForm.getTime8_30());
        calendar.setTime9_00(calendarForm.getTime9_00());
        calendar.setTime9_30(calendarForm.getTime9_30());
        calendar.setTime10_00(calendarForm.getTime10_00());
        calendar.setTime10_30(calendarForm.getTime10_30());
        calendar.setTime11_00(calendarForm.getTime11_00());
        calendar.setTime11_30(calendarForm.getTime11_30());
        calendar.setTime13_00(calendarForm.getTime13_00());
        calendar.setTime13_30(calendarForm.getTime13_30());
        calendar.setTime14_00(calendarForm.getTime14_00());
        calendar.setTime14_30(calendarForm.getTime14_30());
        calendar.setTime15_00(calendarForm.getTime15_00());
        calendar.setTime15_30(calendarForm.getTime15_30());
        calendar.setTime16_00(calendarForm.getTime16_00());
        calendar.setTime16_30(calendarForm.getTime16_30());
        DoctorForm doctor = calendarForm.getDoctor();
        calendar.setDoctor(new Doctor(doctor.getIdDoctor(), doctor.getCabinetNumber(),
                doctor.getSpecialityDoctor()));
        Set<Passport> passports = new HashSet<>();
        if (calendarForm.getPassports()!=null) {
            Set<PassportForm> passportForms = calendarForm.getPassports();
            passportForms.forEach(passportForm -> {
                Passport passport = new Passport(passportForm.getIdPassport(),passportForm.getFamily(),
                        passportForm.getName(),passportForm.getPatronymic(),passportForm.getContactNumber(),
                        passportForm.getDateBirth(),passportForm.getGender(),passportForm.getAddress());
                passports.add(passport);
            });
            calendar.setPassports(passports);
        }
    }
}
