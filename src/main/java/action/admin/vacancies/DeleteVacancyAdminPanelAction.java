package action.admin.vacancies;

import action.interceptor.AuthorizeAs;
import action.vacancies.DeleteVacancyAction;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.exception.ServiceException;

@AuthorizeAs(admin = true)
public class DeleteVacancyAdminPanelAction extends DeleteVacancyAction {

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
