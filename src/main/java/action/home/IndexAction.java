package action.home;

import model.entity.User;
import model.service.CurrentUserService;
import model.service.VacancyService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

    private int vacanciesCount = 0;

    public String execute() {
        vacanciesCount = new VacancyService().getAllVacancies().size();
        return SUCCESS;
    }

    public int getVacanciesCount() {
        return vacanciesCount;
    }

    public void setVacanciesCount(int vacanciesCount) {
        this.vacanciesCount = vacanciesCount;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
