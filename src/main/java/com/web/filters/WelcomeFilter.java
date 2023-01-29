package com.web.filters;


import com.web.facades.PassportFacade;
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
import java.util.List;
import java.util.Set;

@Component
public class WelcomeFilter implements Filter {

    private PositionDoctorFacade positionDoctorFacade;
    private PassportFacade passportFacade;

    public WelcomeFilter(PositionDoctorFacade positionDoctorFacade, PassportFacade passportFacade) {
        this.positionDoctorFacade = positionDoctorFacade;
        this.passportFacade = passportFacade;
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
                    LocalDate currentDate = LocalDate.now();
                    Set<CalendarTicketForm> calendars =
                            passportFacade.getListCalendarUser(userForm.getPassport().getIdPassport());

                    List<CalendarTicketForm> calendarTicketForms = calendars.stream()
                            .filter(calendar -> currentDate.isBefore(calendar.getLocalDate()) ||
                            currentDate.isEqual(calendar.getLocalDate())).toList();

                    session.setAttribute("calendars",calendarTicketForms);

                    List<PositionDoctorForm> positions = positionDoctorFacade.findAll();
                    if (positions.size() != 0) {
                        session.setAttribute("positions", positions);
                    } else {
                        session.removeAttribute("positions");
                    }
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
