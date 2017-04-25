package action.resumes;

import model.entity.User;
import model.service.CurrentUserService;
import model.service.ResumeService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteResumeAction extends ActionSupport {

    protected int resumeId;

    public String execute() {
        new ResumeService().deleteResume(resumeId);
        return SUCCESS;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
