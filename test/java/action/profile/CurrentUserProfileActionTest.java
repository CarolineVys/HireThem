package test.action.profile;

import action.profile.CurrentUserProfileAction;
import com.opensymphony.xwork2.Action;
import model.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CurrentUserProfileActionTest {
    private CurrentUserProfileAction action;

    @Before
    public void setUp(){
        action = new CurrentUserProfileAction();
    }

    @Test
    public void input() throws ServiceException {
        assertEquals(Action.INPUT, action.input());
    }
}
