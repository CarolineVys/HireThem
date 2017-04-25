package action.admin.resumes;

import action.interceptor.AuthorizeAs;
import action.resumes.ManageResumesAction;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.ResumeService;
import model.service.exception.ServiceException;

@AuthorizeAs(admin = true)
public class ManageResumesAdminPanelAction extends ManageResumesAction {

    public String execute() {
        resumes = new ResumeService().getAllResumes();
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
