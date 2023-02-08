package com.web.forms;

import com.web.entity.Doctor;
import org.springframework.web.multipart.MultipartFile;
import com.web.entity.Passport;
import com.web.entity.User;

import java.io.Serializable;

public class UserForm implements Serializable {
    private long id;
    private String userName;
    private String password;
    private String newPassword;
    private String passwordEmail;
    private String confirmPassword;
    private String email;
    private String role;
    private MultipartFile multipartFile;
    private byte[] photo;
    private Passport passport;
    private Doctor doctor;
    private PositionDoctorForm positionDoctor;
    private long idDate;
    private long idTimeTimer;
    private String error;

    public UserForm() {
    }

    public UserForm(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.photo = user.getImage();
        this.passport = user.getPassport();
        this.doctor = user.getDoctor();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPasswordEmail() {
        return passwordEmail;
    }

    public void setPasswordEmail(String passwordEmail) {
        this.passwordEmail = passwordEmail;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public PositionDoctorForm getPositionDoctor() {
        return positionDoctor;
    }

    public void setPositionDoctor(PositionDoctorForm positionDoctor) {
        this.positionDoctor = positionDoctor;
    }

    public long getIdDate() {
        return idDate;
    }

    public void setIdDate(long idDate) {
        this.idDate = idDate;
    }

    public long getIdTimeTimer() {
        return idTimeTimer;
    }

    public void setIdTimeTimer(long idTimeTimer) {
        this.idTimeTimer = idTimeTimer;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
