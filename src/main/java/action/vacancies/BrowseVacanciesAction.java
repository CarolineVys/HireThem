package action.vacancies;

import model.entity.User;
import model.entity.Vacancy;
import model.service.CurrentUserService;
import model.service.VacancyService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class BrowseVacanciesAction extends ActionSupport {

    private String titleToSearch;
    private String summaryToSearch;
    private String requiredExperienceToSearch;
    private String requiredSkillsToSearch;

    private List<Vacancy> vacancies;

    public String input() {
        vacancies = new VacancyService().getAllVacancies();
        return INPUT;
    }

    public String searchVacanciesByTitle() {
        if (StringUtils.isBlank(titleToSearch)) {
            return INPUT;
        }
        vacancies = new VacancyService().findResumesUsingTitle(titleToSearch);
        return SUCCESS;
    }

    public String searchVacanciesBySummary() {
        if (StringUtils.isBlank(summaryToSearch)) {
            return INPUT;
        }
        vacancies = new VacancyService().findResumesUsingSummary(summaryToSearch);
        return SUCCESS;
    }

    public String searchVacanciesBySkills() {
        if (StringUtils.isBlank(requiredSkillsToSearch)) {
            return INPUT;
        }
        vacancies = new VacancyService().findResumesUsingRequiredSkills(requiredSkillsToSearch);
        return SUCCESS;
    }

    public String searchVacanciesByExperience() {
        if (StringUtils.isBlank(requiredExperienceToSearch)) {
            return INPUT;
        }
        vacancies = new VacancyService().findResumesUsingRequiredExperience(requiredExperienceToSearch);
        return SUCCESS;
    }

    public String getTitleToSearch() {
        return titleToSearch;
    }

    public void setTitleToSearch(String titleToSearch) {
        this.titleToSearch = titleToSearch;
    }

    public String getSummaryToSearch() {
        return summaryToSearch;
    }

    public void setSummaryToSearch(String summaryToSearch) {
        this.summaryToSearch = summaryToSearch;
    }

    public String getRequiredExperienceToSearch() {
        return requiredExperienceToSearch;
    }

    public void setRequiredExperienceToSearch(String requiredExperienceToSearch) {
        this.requiredExperienceToSearch = requiredExperienceToSearch;
    }

    public String getRequiredSkillsToSearch() {
        return requiredSkillsToSearch;
    }

    public void setRequiredSkillsToSearch(String requiredSkillsToSearch) {
        this.requiredSkillsToSearch = requiredSkillsToSearch;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    public User getCurrentUser()  {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }
}
