package action.profile;

import com.opensymphony.xwork2.Action;
import model.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ProfileActionTest {
    private ProfileAction action;

    @Before
    public void setUp(){
        action = new ProfileAction();
    }

    @Test
    public void input() throws ServiceException {
        assertEquals(Action.INPUT, action.input());
    }
}
