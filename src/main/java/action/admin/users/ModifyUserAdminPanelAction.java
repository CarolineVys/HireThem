package action.admin.users;

import action.interceptor.AuthorizeAs;
import action.profile.EditProfileAction;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.SessionService;
import model.service.UserService;
import model.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

@AuthorizeAs(admin = true)
public class ModifyUserAdminPanelAction extends EditProfileAction {

    private int userId;
    private User.UserType userType;
    private boolean isAdmin;

    public String input() throws ServiceException {
        User user = new UserService().getUser(userId);
        new SessionService().put("userId", userId);
        name = user.getName();
        surname = user.getSurname();
        about = user.getAbout();
        contactInfo = user.getContactInfo();
        userId = user.getId();
        isAdmin = user.getIsAdmin();
        userType = user.getUserType();
        return INPUT;
    }

    public String execute() {
        try {
            UserService userService = new UserService();
            User user = userService.getUser((Integer) new SessionService().getValue("userId"));
            userService.changeUserInfo(user.getEmail(), user.getUserType(), name, surname, about, contactInfo);
            if (isAdmin) {
                userService.promoteUser(user.getEmail(), user.getUserType());
            } else {
                userService.demoteUser(user.getEmail(), user.getUserType());
            }
            if (StringUtils.isNotBlank(getNewPassword())) {
                userService.changeUserPassword(user.getId(), getNewPassword());
            }
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public User.UserType getUserType() {
        return userType;
    }

    public void setUserType(User.UserType userType) {
        this.userType = userType;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }

    public User.UserType[] getUserTypes() {
        return User.UserType.values();
    }

}
