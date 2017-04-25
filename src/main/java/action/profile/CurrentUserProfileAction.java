package action.profile;

import action.interceptor.AuthorizeAs;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.exception.ServiceException;

@AuthorizeAs
public class CurrentUserProfileAction extends ProfileAction {

    public String input() throws ServiceException {
        User user = new CurrentUserService().getCurrentUserEntity();
        name = user.getName();
        surname = user.getSurname();
        about = user.getAbout();
        contactInfo = user.getContactInfo();
        email = user.getEmail();
        userType = user.getUserType();
        return SUCCESS;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
