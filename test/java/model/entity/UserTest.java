package model.entity;


import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserTest {

    private User user;

    private User.UserType userType = User.UserType.EMPLOYEE;
    private String email = "cena@gmail.com";
    private byte[] encryptedPassword = {34, 23, 120};
    private byte[] passwordSalt = {34, 23, 120};
    private String name = "User";
    private String surname = "Userov";
    private String about = "Bla bla bla.";
    private String contactInfo = "+375295555555";
    private byte[] avatar = {34, 23, 120};
    private boolean isAdmin = false;
    private Set<Resume> resumes = new HashSet<>();
    private Set<Vacancy> vacancies = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUserType(userType);
        user.setEmail(email);
        user.setEncryptedPassword(encryptedPassword);
        user.setPasswordSalt(passwordSalt);
        user.setName(name);
        user.setSurname(surname);
        user.setAbout(about);
        user.setContactInfo(contactInfo);
        user.setIsAdmin(isAdmin);
        user.setResumes(resumes);
        user.setVacancies(vacancies);
    }


    @Test
    public void getId() throws Exception {
        assertNotNull(user.getId());
    }

    @Test
    public void getUserType() throws Exception {
        assertEquals(user.getUserType(), userType);
    }

    @Test
    public void getEmail() throws Exception {
        assertEquals(user.getEmail(), email);
    }

    @Test
    public void getEncryptedPassword() throws Exception {
        assertEquals(user.getEncryptedPassword(), encryptedPassword);
    }

    @Test
    public void getPasswordSalt() throws Exception {
        assertEquals(user.getPasswordSalt(), passwordSalt);
    }

    @Test
    public void getName() throws Exception {
        assertEquals(user.getName(), name);
    }

    @Test
    public void getSurname() throws Exception {
        assertEquals(user.getSurname(), surname);
    }

    @Test
    public void getAbout() throws Exception {
        assertEquals(user.getAbout(), about);
    }

    @Test
    public void getContactInfo() throws Exception {
        assertEquals(user.getContactInfo(), contactInfo);
    }

    @Test
    public void getAdmin() throws Exception {
        assertEquals(user.getIsAdmin(), isAdmin);
    }


    @Test
    public void getResume() throws Exception {
        assertNotNull(user.getResumes());
    }
    @Test
    public void getVacancies() throws Exception {
        assertNotNull(user.getVacancies());
    }

}
