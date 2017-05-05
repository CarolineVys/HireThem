package test.action.vacancies;

import action.vacancies.CreateVacancyAction;
import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CreateVacancyActionTest {
    private CreateVacancyAction action;

    @Before
    public void setUp(){
        action = new CreateVacancyAction();
        action.setTitle("newTitle");
        action.setSummary("newSummary");
        action.setSalary("newSalary");
        action.setRequiredExperience("newExp");
        action.setRequiredSkills("newSkills");
    }

    @Test
    public void execute(){
        assertEquals(Action.SUCCESS, action.execute());
    }
}
