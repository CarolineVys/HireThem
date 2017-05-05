package action.vacancies;

import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BrowseVacanciesActionTest {
    private BrowseVacanciesAction action;

    @Before
    public void setUp(){
        action = new BrowseVacanciesAction();
        action.setTitleToSearch("new");
        action.setSummaryToSearch("new");
        action.setRequiredSkillsToSearch("skills");
        action.setRequiredExperienceToSearch("4");
    }

    @Test
    public void input(){
        assertEquals(Action.INPUT, action.input());
    }

    @Test
    public void searchVacanciesByTitle(){
        assertEquals(Action.SUCCESS, action.searchVacanciesByTitle());
    }

    @Test
    public void searchVacanciesBySummary(){
        assertEquals(Action.SUCCESS, action.searchVacanciesBySummary());
    }

    @Test
    public void searchVacanciesBySkills(){
        assertEquals(Action.SUCCESS, action.searchVacanciesBySkills());
    }

    @Test
    public void searchVacanciesByExperience(){
        assertEquals(Action.SUCCESS, action.searchVacanciesByExperience());
    }
}
