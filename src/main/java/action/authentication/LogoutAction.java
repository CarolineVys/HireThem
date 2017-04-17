package action.authentication;

import model.service.LogoutService;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

    private LogoutService logoutService = new LogoutService();

    public String execute() {
        logoutService.logoutUser();
        return SUCCESS;
    }

}
