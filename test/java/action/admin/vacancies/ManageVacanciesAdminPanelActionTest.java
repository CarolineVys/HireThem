package test.action.admin.vacancies;

import action.admin.vacancies.ManageVacanciesAdminPanelAction;
import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ManageVacanciesAdminPanelActionTest {
    private ManageVacanciesAdminPanelAction action;

    @Before
    public void setUp(){
        action = new ManageVacanciesAdminPanelAction();
    }

    @Test
    public void input(){
        assertEquals(Action.INPUT, action.input());
    }
}
