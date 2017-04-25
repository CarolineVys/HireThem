package action.admin.vacancies;

import action.interceptor.AuthorizeAs;
import action.vacancies.CreateVacancyAction;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.VacancyService;
import model.service.exception.ServiceException;

@AuthorizeAs(admin = true)
public class CreateVacancyAdminPanelAction extends CreateVacancyAction {

    public String execute() {
        try {
            int userId = new CurrentUserService().getCurrentUserId();
            new VacancyService().createVacancy(userId, title, summary, description, salary, requiredExperience, requiredSkills);
        } catch (ServiceException ignored) {
        }
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
