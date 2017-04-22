package model.service;

import model.dao.UserDao;
import model.dao.exception.DaoException;
import model.entity.User;
import model.service.exception.ServiceException;
import model.util.PasswordEncryptionService;
import org.apache.http.client.utils.URIBuilder;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();

    private static List<User.UserType> userTypes = new ArrayList<>();

    static {
        userTypes.add(User.UserType.EMPLOYEE);
        userTypes.add(User.UserType.EMPLOYER);
    }

    public static List<User.UserType> getUserTypes() {
        return userTypes;
    }

    public boolean isSuchUserRegistered(String email, User.UserType userType) {
        try {
            User user = userDao.getUser(email, userType);
            return user != null;
        } catch (DaoException e) {
            return false;
        }
    }

    public User getUser(int id) throws ServiceException {
        try {
            return userDao.getUser(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public User getUser(String email, User.UserType userType) throws ServiceException {
        try {
            return userDao.getUser(email, userType);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public int getUserId(String email, User.UserType userType) throws ServiceException {
        User user = getUser(email, userType);
        return user.getId();
    }

    public void createNewUser(String email, User.UserType userType, String name, String surname, String password) throws ServiceException {
        PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
        byte[] salt;
        salt = passwordEncryptionService.generateSalt();

        byte[] encryptedPassword;
        try {
            encryptedPassword = passwordEncryptionService.getEncryptedPassword(password, salt);
        } catch (Exception e) {
            throw new ServiceException(e);
        }

        userDao.createNewUser(email, userType, encryptedPassword, salt, surname, name);
    }

    public void changeUserInfo(String email, User.UserType userType, String name, String surname, String about,
                               String contactInfo, byte[] avatar) throws ServiceException {
        int userId = getUserId(email, userType);
        userDao.updateUser(userId, name, surname, about, contactInfo, avatar);
    }

    public void promoteUser(String email, User.UserType userType) throws ServiceException {
        userDao.promoteUser(getUserId(email, userType));
    }


    public void demoteUser(String email, User.UserType userType) throws ServiceException {
        userDao.demoteUser(getUserId(email, userType));
    }

    public void deleteUser(int userId) throws ServiceException {
        List<User> users = userDao.getAllUsers();
        int adminsCount = 0;
        for (User user : users) {
            if (user.getIsAdmin()) {
                adminsCount++;
            }
        }
        User userToDelete = getUser(userId);
        if (!userToDelete.getIsAdmin() || adminsCount != 1) {
            userDao.deleteUser(userId);
        } else {
            throw new ServiceException("Cannot delete last admin");
        }
    }

    public void deleteUser(String email, User.UserType userType) throws ServiceException {
        userDao.deleteUser(getUserId(email, userType));
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public String getUserMailtoLink(int userId) throws ServiceException {
        User user = getUser(userId);
        return new URIBuilder().setScheme("mailto").setPath(user.getEmail()).toString();
    }

    public void changeUserPassword(int id, String newPassword) throws ServiceException {
        PasswordEncryptionService service = new PasswordEncryptionService();
        byte[] newPasswordSalt = service.generateSalt();
        byte[] newPasswordEncrypted = service.getEncryptedPassword(newPassword, newPasswordSalt);
        userDao.changeUserPassword(id, newPasswordEncrypted, newPasswordSalt);
    }
}
