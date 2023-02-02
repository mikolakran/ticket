package com.web.facades;

import com.web.dao.DoctorDAO;
import com.web.dao.UserDAO;
import com.web.entity.User;
import com.web.exception.MyException;
import com.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFacade {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private DoctorDAO doctorDAO;

    public UserForm save(UserForm userForm) throws MyException {
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
        User resultByName = userDAO.findByName(user.getUserName());
        return new UserForm(resultByName);
    }

    public List<UserForm> getListUsers() {
        List<UserForm> userFormList = new ArrayList<>();
        userDAO.findListUsers().forEach(user1 -> userFormList.add(new UserForm(user1)));
        return userFormList;
    }

    public List<UserForm> getListDoctors() {
        List<UserForm> userFormList = new ArrayList<>();
        userDAO.findListDoctors().forEach(user1 -> userFormList.add(new UserForm(user1)));
        return userFormList;
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
