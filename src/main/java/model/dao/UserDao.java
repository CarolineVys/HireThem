package model.dao;

import model.dao.exception.DaoException;
import model.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static model.dao.exception.DaoErrorMessages.NOT_FOUND_USER;

public class UserDao extends HibernateDao {

    public byte[] getSalt(String email, User.UserType userType) throws DaoException {
        User user = getUser(email, userType);
        return user.getPasswordSalt();
    }

    public byte[] getEncryptedPassword(String email, User.UserType userType) throws DaoException {
        User user = getUser(email, userType);
        return user.getEncryptedPassword();
    }

    public User getUser(String email, User.UserType userType) throws DaoException {
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("userType", userType));
        try {
            return (User) criteria.list().get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new DaoException(NOT_FOUND_USER, e);
        }
    }

    public User getUser(int userId) throws DaoException {
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id", userId));
        try {
            return (User) criteria.list().get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new DaoException(NOT_FOUND_USER, e);
        }
    }

    public void createNewUser(String email, User.UserType userType, byte[] encryptedPassword, byte[] salt, String surname, String name) {
        session.beginTransaction();
        User user = new User(email, encryptedPassword, salt, name, surname, userType);
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    public void deleteUser(String email, User.UserType userType) {
        session.beginTransaction();
        Query query = session.createQuery("delete User where email = :email and userType = :userType");
        query.setParameter("email", email);
        query.setParameter("userType", userType);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    public void deleteUser(int userId) {
        session.beginTransaction();
        Query query = session.createQuery("delete User where id = :userId");
        query.setParameter("userId", userId);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    public void updateUser(int userId, String name, String surname, String about, String contactInfo) {
        session.beginTransaction();

        User user = session.get(User.class, userId);
        user.setName(name);
        user.setSurname(surname);
        user.setAbout(about);
        user.setContactInfo(contactInfo);

        session.getTransaction().commit();
    }

    public void changeUserPassword(int userId, byte[] encryptedPassword, byte[] salt) {
        session.beginTransaction();

        User user = session.get(User.class, userId);
        user.setPasswordSalt(salt);
        user.setEncryptedPassword(encryptedPassword);

        session.getTransaction().commit();
    }

    public void promoteUser(int userId) {
        session.beginTransaction();
        User user = session.get(User.class, userId);
        user.setIsAdmin(true);
        session.getTransaction().commit();
    }

    public void demoteUser(int userId) {
        session.beginTransaction();
        User user = session.get(User.class, userId);
        user.setIsAdmin(false);
        session.getTransaction().commit();
    }

    public List<User> getAllUsers() {
        Criteria criteria = session.createCriteria(User.class);
        return criteria.list();
    }

}
