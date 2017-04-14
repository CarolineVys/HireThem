package action.authentication;

import model.entity.User;
import model.service.LoginService;
import model.service.UserService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.List;

import static constants.ActionMessages.EMPTY_FIELD;

/**
 * Created by egors.
 */
public class LoginAction extends ActionSupport {

    private String email;
    private String password;
    private User.UserType userType;

    public String input() {
        if (new LoginService().isUserAuthenticated()) {
            return NONE;
        } else {
            return INPUT;
        }
    }

    public String execute() {
        new LoginService().saveUserAuthentication(email, userType);
        return SUCCESS;
    }

    public void validate() {
        if (StringUtils.isBlank(password) ||
                StringUtils.isBlank(email)) {
            addActionError("Empty fields are not allowed");
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            addActionError("Wrong email is provided");
        }
        try {
            new LoginService().tryAuthenticateUser(email, password, userType);
        } catch (ServiceException e) {
            addFieldError("email", e.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @RequiredFieldValidator(message = EMPTY_FIELD)
    public User.UserType getUserType() {
        return userType;
    }

    public void setUserType(User.UserType userType) {
        this.userType = userType;
    }

    public List<User.UserType> getUserTypes() {
        return UserService.getUserTypes();
    }

    public User.UserType getDefaultUserType() {
        return User.UserType.EMPLOYEE;
    }

}
