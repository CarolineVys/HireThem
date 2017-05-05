package test.action.authentication;

import action.authentication.SigninAction;
import com.opensymphony.xwork2.Action;
import model.entity.User;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SigninActionTest {
    private SigninAction action;

    @Before
    public void setUp(){
        action = new SigninAction();
        action.setEmail("aaaa2345@gmail.com");
        action.setUserType(User.UserType.EMPLOYER);
        action.setName("Naaame");
        action.setSurname("Surnaaame");
        action.setPassword("newPASS8");
    }

    @Test
    public void input(){
        assertEquals(Action.SUCCESS, action.input());
    }

    @Test
    public void execute(){
        assertEquals(Action.SUCCESS, action.execute());
    }
}
