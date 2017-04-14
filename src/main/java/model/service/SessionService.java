package model.service;

import model.dao.SessionDao;
import model.service.exception.ServiceException;

import java.util.UUID;

import static model.service.exception.ServiceErrorMessage.COOKIE_NOT_FOUND;

/**
 * Created by egors.
 */
public class SessionService {

    private SessionDao sessionDao = new SessionDao();

    public String generateSessionToken() {
        return UUID.randomUUID().toString();
    }

    public void saveUserAuthentication(int id, String token) {
        sessionDao.remove(String.valueOf(id));
        sessionDao.put(String.valueOf(id), token);     // user id => token
    }

    public boolean sessionContainsToken(String token) {
            return sessionDao.containsValue(token);
    }

    public String getUserToken(int id) throws ServiceException {
        try {
            return (String) sessionDao.getValue(Integer.toString(id));
        } catch (Exception e) {
            throw new ServiceException(COOKIE_NOT_FOUND);
        }
    }

    public void removeUser(int id) {
        sessionDao.remove(Integer.toString(id));
    }

    public void put(String key, Object value) {
        sessionDao.put(key, value);
    }

    public boolean contains(Object value) {
        return sessionDao.containsValue(value);
    }

    public Object getValue(String key) {
        return sessionDao.getValue(key);
    }
}

