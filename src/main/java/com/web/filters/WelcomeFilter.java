package com.web.filters;


import com.web.facades.DoctorFacade;
import com.web.facades.PositionDoctorFacade;
import com.web.forms.CalendarTicketForm;
import com.web.forms.PositionDoctorForm;
import com.web.forms.UserForm;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WelcomeFilter implements Filter {

    private PositionDoctorFacade positionDoctorFacade;
    private DoctorFacade doctorFacade;

    public WelcomeFilter(PositionDoctorFacade positionDoctorFacade, DoctorFacade doctorFacade) {
        this.positionDoctorFacade = positionDoctorFacade;
        this.doctorFacade = doctorFacade;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        if(session != null) {
            UserForm userForm = (UserForm) session.getAttribute("userSession");
            session.removeAttribute("userAndAdmin");
            if (userForm != null) {
                if (userForm.getRole().equals("user")) {
                    List<PositionDoctorForm> positions = positionDoctorFacade.findAll();
                    if (positions.size() != 0) {
                        session.setAttribute("positions", positions);
                    } else {
                        session.removeAttribute("positions");
                    }
                }else if (userForm.getRole().equals("doctor")){
                    LocalDate currentDate = LocalDate.now();
                    List<CalendarTicketForm> calendars = doctorFacade.getCalendar(userForm.getDoctor().getIdDoctor()).
                            stream().filter(calendar -> currentDate.isBefore(calendar.getLocalDate()) ||
                                            currentDate.isEqual(calendar.getLocalDate()))
                            .sorted(Comparator.comparing(CalendarTicketForm::getLocalDate)).collect(Collectors.toList());
                    if (calendars.size()!=0){
                        session.setAttribute("calendarDoctor",calendars);
                    }
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
