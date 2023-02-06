package com.web.facades;

import com.web.dao.TimerTimeDAO;
import com.web.entity.Calendar;
import com.web.entity.Doctor;
import com.web.entity.Passport;
import com.web.entity.TimerTime;
import com.web.forms.TimerTimeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimerTimeFacade {

    @Autowired
    private TimerTimeDAO timerTimeDAO;

    public TimerTime save(TimerTimeForm timerTimeForm){
        TimerTime timerTime = new TimerTime();
        build(timerTime,timerTimeForm);
        return timerTimeDAO.save(timerTime);
    }

    private void build(TimerTime timerTime, TimerTimeForm timerTimeForm) {
        timerTime.setIdTime(timerTimeForm.getIdTime());
        timerTime.setTime(timerTimeForm.getTime());
        timerTime.setDoctor(new Doctor(timerTimeForm.getDoctor()));
        if (timerTimeForm.getPassport()!=null) {
            timerTime.setPassport(new Passport());
        }
        timerTime.setCalendar(new Calendar(timerTimeForm.getCalendar()));
    }
}
