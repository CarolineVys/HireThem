package model.service;

import model.service.exception.ServiceException;


/**
 * Created by egors.
 */
public class LogoutService {

    private CookieService cookieService = new CookieService();
    private SessionService sessionService = new SessionService();

    public void logoutUser() {
        try {
            int userId = cookieService.getCurrentUserId();
            sessionService.removeUser(userId);
            cookieService.deleteAllCookies();
        } catch (ServiceException ignored) {

        }
    }

}
