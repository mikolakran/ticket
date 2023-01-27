package com.web.facades;

import com.web.dao.CalendarTicketDAO;
import com.web.entity.CalendarTicket;
import com.web.entity.Doctor;
import com.web.entity.Passport;
import com.web.forms.CalendarTicketForm;
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
public class CalendarTicketFacade {

    @Autowired
    private CalendarTicketDAO calendarTicketDAO;

    public CalendarTicketForm save(CalendarTicketForm calendarTicketForm){
        CalendarTicket calendarTicket = new CalendarTicket();
        buildUser(calendarTicket, calendarTicketForm);
        CalendarTicket resultSave = calendarTicketDAO.save(calendarTicket);
        return new CalendarTicketForm(resultSave);
    }

    public Set<CalendarTicketForm> findAll(){
        Set<CalendarTicketForm> calendarTicketForms = new HashSet<>();
        calendarTicketDAO.findAll().forEach(calendarTicket -> calendarTicketForms.add(new CalendarTicketForm(calendarTicket)));
        return calendarTicketForms;
    }

    public CalendarTicketForm findId(long idDate){
        CalendarTicket calendarTicket = calendarTicketDAO.get(idDate);
        return new CalendarTicketForm(calendarTicket);
    }

    public Set<PassportForm> getListPassport(long idDate) {
        Set<PassportForm> passportForms = new HashSet<>();
        Set<Passport> listPassport = calendarTicketDAO.getListPassport(idDate);
        listPassport.forEach(passport -> {
            PassportForm passportForm = new PassportForm(passport);
            passportForms.add(passportForm);
        });
        return passportForms;
    }

    public List<CalendarTicketForm> findByDoctor_IdDoctor(long idDoctor,int pageNo,int pageSize){
       Pageable pageable = PageRequest.of(pageNo,pageSize);
       List<CalendarTicketForm> calendarTicketForms = new ArrayList<>();
        List<CalendarTicket> byDoctor_idDoctor = calendarTicketDAO.findByDoctor_IdDoctor(idDoctor, pageable);
        byDoctor_idDoctor.forEach(calendarTicket -> {
            CalendarTicketForm calendarTicketForm = new CalendarTicketForm(calendarTicket);
            calendarTicketForms.add(calendarTicketForm);
        });
        return calendarTicketForms;
    }

    private void buildUser(CalendarTicket calendarTicket , CalendarTicketForm calendarTicketForm){
        calendarTicket.setIdDate(calendarTicketForm.getIdDate());
        calendarTicket.setLocalDate(calendarTicketForm.getLocalDate());
        calendarTicket.setTime8_30(calendarTicketForm.getTime8_30());
        calendarTicket.setTime9_00(calendarTicketForm.getTime9_00());
        calendarTicket.setTime9_30(calendarTicketForm.getTime9_30());
        calendarTicket.setTime10_00(calendarTicketForm.getTime10_00());
        calendarTicket.setTime10_30(calendarTicketForm.getTime10_30());
        calendarTicket.setTime11_00(calendarTicketForm.getTime11_00());
        calendarTicket.setTime11_30(calendarTicketForm.getTime11_30());
        calendarTicket.setTime13_00(calendarTicketForm.getTime13_00());
        calendarTicket.setTime13_30(calendarTicketForm.getTime13_30());
        calendarTicket.setTime14_00(calendarTicketForm.getTime14_00());
        calendarTicket.setTime14_30(calendarTicketForm.getTime14_30());
        calendarTicket.setTime15_00(calendarTicketForm.getTime15_00());
        calendarTicket.setTime15_30(calendarTicketForm.getTime15_30());
        calendarTicket.setTime16_00(calendarTicketForm.getTime16_00());
        calendarTicket.setTime16_30(calendarTicketForm.getTime16_30());
        DoctorForm doctor = calendarTicketForm.getDoctor();
        calendarTicket.setDoctor(new Doctor(doctor.getIdDoctor(), doctor.getCabinetNumber(),
                doctor.getSpecialityDoctor()));
        Set<Passport> passports = new HashSet<>();
        if (calendarTicketForm.getPassports()!=null) {
            Set<PassportForm> passportForms = calendarTicketForm.getPassports();
            passportForms.forEach(passportForm -> {
                Passport passport = new Passport(passportForm.getIdPassport(),passportForm.getFamily(),
                        passportForm.getName(),passportForm.getPatronymic(),passportForm.getContactNumber(),
                        passportForm.getDateBirth(),passportForm.getGender(),passportForm.getAddress());
                passports.add(passport);
            });
            calendarTicket.setPassports(passports);
        }
    }
}
