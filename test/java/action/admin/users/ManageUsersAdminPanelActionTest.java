package action.admin.users;

import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ManageUsersAdminPanelActionTest {
    private ManageUsersAdminPanelAction action;

    @Before
    public void setUp(){
        action = new ManageUsersAdminPanelAction();
        action.setUserId(2);
    }

    @Test
    public void input(){
        assertEquals(Action.INPUT, action.input());
    }
}
