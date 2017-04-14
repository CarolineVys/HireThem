package action.admin.users;

import action.interceptor.AuthorizeAs;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.SessionService;
import model.service.UserService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

@AuthorizeAs(admin = true)
public class DeleteUserAdminPanelAction extends ActionSupport {

    private int userId;

    public String execute() throws ServiceException {
        new UserService().deleteUser(userId);
        new SessionService().removeUser(userId);
        return SUCCESS;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
