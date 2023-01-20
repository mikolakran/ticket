package com.web.facades;

import com.web.dao.DoctorDAO;
import com.web.dao.UserDAO;
import com.web.entity.User;
import com.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private DoctorDAO doctorDAO;

    public UserForm save(UserForm userForm){
        User user = new User();
        buildUser(user, userForm);
        if (userForm.getDoctor()!=null){
            user.setDoctor(doctorDAO.save(userForm.getDoctor()));
        }
        User resultSave = userDAO.save(user);
        return new UserForm(resultSave);
    }

    public UserForm getByName(String name) {
        User user = new User();
        UserForm userForm = new UserForm();
        userForm.setUserName(name);
        buildUser(user, userForm);
        User resultByName = userDAO.getByName(user.getUserName());
        return new UserForm(resultByName);
    }

    private void buildUser(User user, UserForm userForm) {
        user.setId(userForm.getId());
        user.setUserName(userForm.getUserName());
        user.setPassword(userForm.getPassword());
        user.setEmail(userForm.getEmail());
        user.setRole(userForm.getRole());
        user.setImage(userForm.getPhoto());
        user.setPassport(userForm.getPassport());
        user.setDoctor(userForm.getDoctor());
    }
}
