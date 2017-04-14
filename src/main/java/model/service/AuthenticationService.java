package model.service;

import model.entity.User;
import model.service.exception.ServiceException;

public class AuthenticationService {

    private UserService userService = new UserService();

    public void authenticateCurrentUserAsAdmin() throws ServiceException {
        if (!isCurrentUserAdmin()) {
            throw new ServiceException("Current user is not authorized to perform the task");
        }
    }

    public boolean isCurrentUserAdmin() throws ServiceException {
        return new CurrentUserService().getCurrentUserEntity().getIsAdmin();
    }

    public void authenticateCurrentUserByToken() throws ServiceException {
        CookieService cookieService = new CookieService();
        SessionService sessionService = new SessionService();
        String userToken = cookieService.getUserToken();
        int userId = cookieService.getCurrentUserId();
        if (!userToken.equals(sessionService.getUserToken(userId))) {
            throw new ServiceException("User has provided wrong token");
        }
    }

    public void verifyUser(int userId, String email, User.UserType userType) throws ServiceException {
        if (!isThereUserWithSuchCredentials(userId, email, userType)) {
            throw new ServiceException("[UserId <=> email, userType] verification failed");
        }
    }

    public boolean isThereUserWithSuchCredentials(int userId, String email, User.UserType userType) throws ServiceException {
        return userId == userService.getUserId(email, userType);
    }

    public void authenticateCurrentUser(String email, User.UserType userType) throws ServiceException {
        if (isUserCurrent(email, userType)) {
            throw new ServiceException("Current user id does not correspond to provided email and userType");
        }
    }

    public boolean isUserCurrent(String email, User.UserType userType) throws ServiceException {
        int userId = new CurrentUserService().getCurrentUserId();
        return userService.getUserId(email, userType) != userId;
    }

    public boolean isUserAdmin(String email, User.UserType userType) throws ServiceException {
        return userService.getUser(email, userType).getIsAdmin();
    }

}
