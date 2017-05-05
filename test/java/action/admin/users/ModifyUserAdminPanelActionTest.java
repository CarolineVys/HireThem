package test.action.admin.users;

import action.admin.users.ModifyUserAdminPanelAction;
import com.opensymphony.xwork2.Action;
import model.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ModifyUserAdminPanelActionTest {
    private ModifyUserAdminPanelAction action;

    @Before
    public void setUp(){
        action = new ModifyUserAdminPanelAction();
        action.setUserId(2);
        action.setIsAdmin(true);
    }

    @Test
    public void input() throws ServiceException {
        assertEquals(Action.INPUT, action.input());
    }

    @Test
    public void execute(){
        assertEquals(Action.INPUT, action.execute());
    }
}
