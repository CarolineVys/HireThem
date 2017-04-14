package action.admin.users;

import action.authentication.SigninAction;
import action.interceptor.AuthorizeAs;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.exception.ServiceException;

@AuthorizeAs(admin = true)
public class CreateUserAdminPanelAction extends SigninAction {

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }



}
