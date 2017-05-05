package action.authentication;

import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LogoutActionTest {
    private LogoutAction action;

    @Before
    public void setUp(){
        action = new LogoutAction();
    }

    @Test
    public void execute(){
        assertEquals(Action.SUCCESS, action.execute());
    }
}
