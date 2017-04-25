package action.resumes;

import action.interceptor.AuthorizeAs;
import model.entity.Resume;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.ResumeService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

@AuthorizeAs(userType = "EMPLOYEE")
public class ManageResumesAction extends ActionSupport {

    protected List<Resume> resumes;
    private User currentUser;

    public String execute() {
        try {
            currentUser = new CurrentUserService().getCurrentUserEntity();
            resumes = new ResumeService().getResumes(currentUser.getId());
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
