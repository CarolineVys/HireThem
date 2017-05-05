package test.action.admin.users;

import action.admin.users.ManageUsersAdminPanelAction;
import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ManageUsersAdminPanelActionTest {
    private ManageUsersAdminPanelAction action;

    @Before
    public void setUp(){
        action = new ManageUsersAdminPanelAction();
        action.setUserId(10);
    }

    @Test
    public void input(){
        assertEquals(Action.INPUT, action.input());
    }

    @Test
    public void execute(){
        assertEquals(Action.INPUT, action.execute());
    }
}
