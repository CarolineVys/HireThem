package model.service;

import model.dao.UserDao;
import model.dao.exception.DaoException;
import model.entity.User;
import model.service.exception.ServiceException;
import model.util.PasswordEncryptionService;


/**
 * Created by egors.
 */
public class LoginService {

    private CookieService cookieService = new CookieService();
    private SessionService sessionService = new SessionService();

    public void tryAuthenticateUser(String email, String password, User.UserType userType) throws ServiceException {
        UserDao userDao = new UserDao();

        byte[] salt;
        try {
            salt = userDao.getSalt(email, userType);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        byte[] encryptedInputPassword;
        try {
            encryptedInputPassword = userDao.getEncryptedPassword(email, userType);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        new PasswordEncryptionService().tryAuthenticateUser(password, encryptedInputPassword, salt);
    }

    public boolean isUserAuthenticated() {
        String token;
        try {
            token = cookieService.getUserToken();
            return sessionService.sessionContainsToken(token);
        } catch (ServiceException e) {
            return false;
        }
    }

    public void saveUserAuthentication(int userId) {
        String token = sessionService.generateSessionToken();
        sessionService.saveUserAuthentication(userId, token);
        cookieService.addUserIdCookie(userId);
        cookieService.addUserTokenCookie(token);
    }


    public void saveUserAuthentication(String email, User.UserType userType) {
        int userId = 0;
        try {
            userId = new UserService().getUserId(email, userType);
        } catch (ServiceException ignored) {
            // this check is redundant
        }
        saveUserAuthentication(userId);
    }
}
