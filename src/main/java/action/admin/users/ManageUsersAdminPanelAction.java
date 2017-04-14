package action.admin.users;

import action.interceptor.AuthorizeAs;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.SessionService;
import model.service.UserService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

@AuthorizeAs(admin = true)
public class ManageUsersAdminPanelAction extends ActionSupport {

    private List<User> users;
    private int userId;

    public String input() {
        users = new UserService().getAllUsers();
        return INPUT;
    }

    public String execute() {
        new SessionService().put("userId", userId);
        return SUCCESS;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
