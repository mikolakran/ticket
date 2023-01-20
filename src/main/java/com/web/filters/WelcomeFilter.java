package com.web.filters;


import com.web.facades.PositionDoctorFacade;
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
import java.util.List;

@Component
public class WelcomeFilter implements Filter {

    private PositionDoctorFacade positionDoctorFacade;

    public WelcomeFilter(PositionDoctorFacade positionDoctorFacade) {
        this.positionDoctorFacade = positionDoctorFacade;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        if(session != null) {
            UserForm userForm = (UserForm) session.getAttribute("userSession");
            session.removeAttribute("userAndAdmin");
            String deleteIdTopic = request.getParameter("deleteIdTopic");
            if (userForm != null) {
                List<PositionDoctorForm> positions = positionDoctorFacade.findAll();
                if (positions.size() != 0) {
                    session.setAttribute("positions", positions);
                }else {
                    session.removeAttribute("positions");
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
