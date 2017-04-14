package action.admin.vacancies;

import action.interceptor.AuthorizeAs;
import action.vacancies.ManageVacanciesAction;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.VacancyService;
import model.service.exception.ServiceException;

@AuthorizeAs(admin = true)
public class ManageVacanciesAdminPanelAction extends ManageVacanciesAction {

    public String input() {
        vacancies = new VacancyService().getAllVacancies();
        return INPUT;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
