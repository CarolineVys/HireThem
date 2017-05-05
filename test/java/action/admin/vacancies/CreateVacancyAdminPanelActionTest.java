package test.action.admin.vacancies;

import action.admin.vacancies.CreateVacancyAdminPanelAction;
import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CreateVacancyAdminPanelActionTest {
    private CreateVacancyAdminPanelAction action;

    @Before
    public void setUp(){
        action = new CreateVacancyAdminPanelAction();
    }

    @Test
    public void execute(){
        assertEquals(Action.INPUT, action.execute());
    }
}
