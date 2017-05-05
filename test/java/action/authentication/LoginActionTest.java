package action.authentication;

import com.opensymphony.xwork2.Action;
import model.entity.User;
import model.service.LoginService;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LoginActionTest {
    private LoginAction action;

    @Before
    public void setUp(){
        action = new LoginAction();
        action.setEmail("gre@fhfg.com");
        action.setUserType(User.UserType.EMPLOYER);
    }

    @Test
    public void input() {
        String expectedAction = Action.NONE;
        if (!new LoginService().isUserAuthenticated())
            expectedAction = Action.INPUT;
        assertEquals(expectedAction, action.input());
    }

    @Test
    public void execute(){
        assertEquals(Action.SUCCESS, action.execute());
    }
}
