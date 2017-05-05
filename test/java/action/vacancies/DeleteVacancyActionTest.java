package action.vacancies;

import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DeleteVacancyActionTest {
    private DeleteVacancyAction action;

    @Before
    public void setUp(){
        action = new DeleteVacancyAction();
        action.setVacancyId(2);
    }

    @Test
    public void execute(){
        assertEquals(Action.SUCCESS, action.execute());
    }
}
