package com.web.controllers;

import com.web.entity.Doctor;
import com.web.entity.Passport;
import com.web.entity.TimerTime;
import com.web.exception.MyException;
import com.web.facades.*;
import com.web.forms.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminRestController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private PassportFacade passportFacade;

    @Autowired
    private PositionDoctorFacade positionDoctorFacade;

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private DoctorFacade doctorFacade;

    @Autowired
    private CalendarFacade calendarFacade;

    @Autowired
    private TimerTimeFacade timerTimeFacade;


    @RequestMapping(value = "/createDoctor", method = RequestMethod.POST)
    public ResponseEntity<UserForm> addDoctor(
            @RequestBody() UserForm userForm) throws IOException {
        UserForm user;
        MultipartFile multipartFile = userForm.getMultipartFile();
        if (multipartFile != null) {
            userForm.setPhoto(multipartFile.getBytes());
        }
        try {
            //save user
            userForm.setPasswordEmail(userForm.getPassword());
            userForm.setPassword(BCrypt.hashpw(userForm.getPassword(), BCrypt.gensalt(12)));
            userForm.setRole("doctor");
            user = userFacade.save(userForm);
            //save doctor
            Doctor doctor = user.getDoctor();
            DoctorForm doctorForm = new DoctorForm(doctor);
            PositionDoctorForm positionDoctorForm = positionDoctorFacade.findByName(userForm.getPositionDoctor());
            Set<DoctorForm> listDoctor = positionDoctorFacade.getListDoctor(positionDoctorForm.getPositionDoctorId());
            listDoctor.add(doctorForm);
            positionDoctorForm.setDoctors(listDoctor);
            positionDoctorFacade.update(positionDoctorForm);
            //send email
            /*SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setSubject("Registration user");
            message.setText("Hello, your login - "+user.getUserName()+" password - "+userForm.getPasswordEmail()+
                    "  position - "+
                    positionDoctorForm.getPosition()+" beginning work - " +positionDoctorForm.getBeginningWork()+
                    " end work - "+positionDoctorForm.getEndWork()+" beginning break - "
                    +positionDoctorForm.getBeginningBreak()+" end break - "+positionDoctorForm.getEndBreak());
            this.emailSender.send(message);*/
            //create calendar
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (MyException e) {
            user = new UserForm();
            user.setError(e.getMessage());
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/addPositionDoctor", method = RequestMethod.POST)
    public ResponseEntity<PositionDoctorForm> addPositionDoctor(
            @RequestBody() PositionDoctorForm positionDoctorForm) {
        PositionDoctorForm resultSave = null;
        try {
            resultSave = positionDoctorFacade.save(positionDoctorForm);
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(resultSave, HttpStatus.OK);
    }

    @RequestMapping(value = "/getDoctor", method = RequestMethod.POST)
    public ResponseEntity<DoctorForm> getDoctor(@RequestBody() DoctorForm doctorForm, HttpServletRequest request) {
        Passport passport = doctorForm.getUser().getPassport();
        Passport resultPassport = passportFacade.findNameAndFamilyAndPatronymic(passport);
        Doctor doctor = resultPassport.getUser().getDoctor();

        DoctorForm resultDoctorForm = new DoctorForm(doctor.getIdDoctor(), doctor.getCabinetNumber(),
                doctor.getSpecialityDoctor(), doctor.getUser());
        request.getSession().setAttribute("doctor", resultDoctorForm);
        return new ResponseEntity<>(new DoctorForm(doctor), HttpStatus.OK);
    }

    @RequestMapping(value = "/doctor/createCalendarDoctor", method = RequestMethod.POST)
    public ResponseEntity<CalendarForm> createCalendarDoctor(@RequestBody CalendarForm calendarForm,
                                                             @SessionAttribute(value = "doctor") DoctorForm doctorForm) {
        CalendarForm resultSaveCalendarForm;
        List<CalendarForm> calendars = doctorFacade.getCalendar(doctorForm.getIdDoctor());

        if (calendars.size() != 0) {
            CalendarForm calendarMaxValue = calendars.stream().max(Comparator.comparing(CalendarForm::getLocalDate)).
                    orElseThrow(NoSuchElementException::new);

            LocalDate localDateMax = calendarMaxValue.getLocalDate();
            LocalDate localDate = localDateMax.plusDays(1);
            resultSaveCalendarForm = addCalendarDoctor(calendarForm, doctorForm, localDate);

        } else {
            LocalDate currentDate = LocalDate.now();
            resultSaveCalendarForm = addCalendarDoctor(calendarForm, doctorForm, currentDate);
        }
        return new ResponseEntity<>(resultSaveCalendarForm, HttpStatus.OK);
    }

    private CalendarForm addCalendarDoctor(CalendarForm calendarForm, DoctorForm doctorForm, LocalDate localDateMax) {
        CalendarForm resultSave = null;
        while (localDateMax.isBefore(calendarForm.getLocalDate())
                || localDateMax.isEqual(calendarForm.getLocalDate())) {

            DayOfWeek dayOfWeek = localDateMax.getDayOfWeek();
            String nameWeek = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            if (!nameWeek.equals(calendarForm.getFirstDayOff())
                    && !nameWeek.equals(calendarForm.getSecondDayOff())) {

                CalendarForm calendarLocalDate = calendarFacade.findLocalDate(localDateMax);
                Set<DoctorForm> listDoctor = calendarFacade.findListDoctor(localDateMax);
                if (listDoctor == null) {
                    listDoctor = new HashSet<>();
                }
                listDoctor.add(doctorForm);
                calendarLocalDate.setDoctors(listDoctor);
                resultSave = calendarFacade.save(calendarLocalDate);

                int timerMinutes = calendarForm.getTimerMinutes();
                createTimerTimeForDoctor(doctorForm, resultSave, timerMinutes);

            }
            localDateMax = localDateMax.plusDays(1);
        }
        return resultSave;
    }

    private void createTimerTimeForDoctor(DoctorForm doctorForm, CalendarForm calendarLocalDate, int timerMinutes) {
        if (timerMinutes != 0) {
            PositionDoctorForm positionDoctor = new PositionDoctorForm();
            Set<PositionDoctorForm> position = doctorFacade.getPosition(doctorForm.getIdDoctor());
            if (position.size() == 1) {
                position.forEach(positionDoctorForm -> {
                    positionDoctor.setPositionDoctorId(positionDoctorForm.getPositionDoctorId());
                    positionDoctor.setPosition(positionDoctorForm.getPosition());
                    positionDoctor.setBeginningWork(positionDoctorForm.getBeginningWork());
                    positionDoctor.setBeginningBreak(positionDoctorForm.getBeginningBreak());
                    positionDoctor.setEndBreak(positionDoctorForm.getEndBreak());
                    positionDoctor.setEndWork(positionDoctorForm.getEndWork());
                });
            } else {
                throw new RuntimeException("doctor position more 1 or 0");
            }
            countTimerTime(doctorForm, calendarLocalDate, timerMinutes,
                    positionDoctor.getBeginningWork(),  positionDoctor.getBeginningBreak());

            countTimerTime(doctorForm, calendarLocalDate, timerMinutes,
                    positionDoctor.getEndBreak(), positionDoctor.getEndWork());
        }
    }

    private void countTimerTime(DoctorForm doctorForm, CalendarForm calendarLocalDate, int timerMinutes,
                                LocalTime beginningWork, LocalTime beginningBreak) {
        while (beginningWork.isBefore(beginningBreak)) {
            TimerTimeForm timerTimeForm = new TimerTimeForm();
            timerTimeForm.setTime(beginningWork);
            timerTimeForm.setDoctor(doctorForm);
            timerTimeForm.setCalendar(calendarLocalDate);
            timerTimeFacade.save(timerTimeForm);
            beginningWork = beginningWork.plusMinutes(timerMinutes);
        }
    }
}
