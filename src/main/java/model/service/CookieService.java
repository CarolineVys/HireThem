package model.service;

import model.dao.CookieDao;
import model.service.exception.ServiceException;

public class CookieService {

    private CookieDao cookieDao = new CookieDao();

    static private final String userIdCookieName = "user-id";
    static private final String userTokenCookieName = "user-token";

    public void addUserIdCookie(int userId) {
        cookieDao.add(userIdCookieName, String.valueOf(userId));
    }

    public void addUserTokenCookie(String token) {
        cookieDao.add(userTokenCookieName, token);
    }

    public void deleteAllCookies() {
        cookieDao.remove(userIdCookieName);
        cookieDao.remove(userTokenCookieName);
    }

    public int getCurrentUserId() throws ServiceException {
        try {
            return Integer.parseInt(cookieDao.get(userIdCookieName));
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public String getUserToken() throws ServiceException {
        return cookieDao.get(userTokenCookieName);
    }

}
