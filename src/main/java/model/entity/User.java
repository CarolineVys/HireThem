package model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private User.UserType userType;

    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "encrypted_password", nullable = false)
    private byte[] encryptedPassword;

    @NotEmpty
    @Column(name = "password_salt", nullable = false)
    private byte[] passwordSalt;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "surname")
    private String surname;

    @Column(name = "about")
    private String about;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "avatar")
    private byte[] avatar;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    @OneToMany(mappedBy = "employee", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private Set<Resume> resumes = new HashSet<>();

    @OneToMany(mappedBy = "employer", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private Set<Vacancy> vacancies = new HashSet<>();

    public User(String email, byte[] encryptedPassword, byte[] passwordSalt,
                String name, String surname, User.UserType userType) {
        this.userType = userType;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.passwordSalt = passwordSalt;
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(byte[] encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public byte[] getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(byte[] passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Set<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(Set<Resume> resumes) {
        this.resumes = resumes;
    }

    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public enum UserType {
        EMPLOYEE,
        EMPLOYER
    }
}
