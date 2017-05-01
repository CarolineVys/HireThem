package action.profile;

import model.entity.User;
import model.service.CurrentUserService;
import model.service.UserService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport {

    protected int id;
    protected String email;
    protected User.UserType userType;
    protected String name;
    protected String surname;
    protected String about;
    protected String contactInfo;

    public String input() throws ServiceException {
        User user = new UserService().getUser(id);
        name = user.getName();
        surname = user.getSurname();
        about = user.getAbout();
        contactInfo = user.getContactInfo();
        email = user.getEmail();
        userType = user.getUserType();
        return INPUT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User.UserType getUserType() {
        return userType;
    }

    public void setUserType(User.UserType userType) {
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }

}
