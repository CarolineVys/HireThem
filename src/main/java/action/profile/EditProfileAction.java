package action.profile;

import action.interceptor.AuthorizeAs;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.LoginService;
import model.service.UserServiceWithAuthorization;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.commons.lang3.StringUtils;

import static constants.ActionMessages.EMPTY_FIELD;

@AuthorizeAs
public class EditProfileAction extends ActionSupport {

    protected String name;
    protected String surname;
    protected String about;
    protected String contactInfo;

    private String oldPassword;
    private String newPassword;
    private String email;

    private UserServiceWithAuthorization userService = new UserServiceWithAuthorization();

    public String input() throws ServiceException {
        User user = new CurrentUserService().getCurrentUserEntity();
        name = user.getName();
        surname = user.getSurname();
        about = user.getAbout();
        contactInfo = user.getContactInfo();
        email = user.getEmail();
        return INPUT;
    }

    public String execute() {
        try {
            User user = new CurrentUserService().getCurrentUserEntity();
            userService.changeUserInfo(user.getEmail(), user.getUserType(), name, surname, about, contactInfo);
            if (StringUtils.isNotEmpty(newPassword)) {
                userService.changeUserPassword(user.getId(), newPassword);
            }
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public void validate() {
        try {
            User user = new CurrentUserService().getCurrentUserEntity();
            if (StringUtils.isNotEmpty(newPassword)) {
                new LoginService().tryAuthenticateUser(user.getEmail(), oldPassword, user.getUserType());
            }
        } catch (ServiceException e) {
            addActionError(e.getMessage());
        }
    }

    @RequiredStringValidator(message = EMPTY_FIELD)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequiredStringValidator(message = EMPTY_FIELD)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
