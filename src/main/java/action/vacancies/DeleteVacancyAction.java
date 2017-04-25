package action.vacancies;

import model.entity.User;
import model.service.CurrentUserService;
import model.service.VacancyService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteVacancyAction extends ActionSupport {

    protected int vacancyId;

    public String execute() {
        new VacancyService().deleteVacancy(vacancyId);
        return SUCCESS;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
