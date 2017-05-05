package model.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class PasswordEncryptionServiceTest {

    private PasswordEncryptionService passwordEncryptionService;

    @Before
    public void setUp() throws Exception {
        passwordEncryptionService = new PasswordEncryptionService();
    }

    @Test
    public void tryAuthenticateUser() throws Exception {
        byte[] salt = passwordEncryptionService.generateSalt();
        String password = "password";
        byte[] encryptedPassword = passwordEncryptionService.getEncryptedPassword(password, salt);
        passwordEncryptionService.tryAuthenticateUser(password, encryptedPassword, salt);
    }

    @Test
    public void getEncryptedPassword() throws Exception {
        byte[] salt = passwordEncryptionService.generateSalt();
        String password = "password";
        byte[] encryptedPassword = passwordEncryptionService.getEncryptedPassword(password, salt);
        assertTrue(encryptedPassword.length > 0);
    }

    @Test
    public void generateSalt() throws Exception {
        byte[] salt = passwordEncryptionService.generateSalt();
        assertTrue(salt.length > 0);
    }

}