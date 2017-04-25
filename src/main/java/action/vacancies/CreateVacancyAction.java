package action.vacancies;

import action.interceptor.AuthorizeAs;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.VacancyService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

@AuthorizeAs(userType = "EMPLOYER")
public class CreateVacancyAction extends ActionSupport {

    protected String title;
    protected String summary;
    protected String description;
    protected String salary;
    protected String requiredExperience;
    protected String requiredSkills;

    public String execute() {
        try {
            int userId = new CurrentUserService().getCurrentUserId();
            new VacancyService().createVacancy(userId, title, summary, description, salary, requiredExperience, requiredSkills);
        } catch (ServiceException ignored) {
        }
        return SUCCESS;
    }

    public void validate() {
        if (StringUtils.isEmpty(title)) {
            addActionError("Title cannot be empty");
        }
        if (StringUtils.isEmpty(summary)) {
            addActionError("Summary cannot be empty");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(String requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
