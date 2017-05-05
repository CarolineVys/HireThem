package test.action.admin.users;

import action.admin.users.DeleteUserAdminPanelAction;
import com.opensymphony.xwork2.Action;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DeleteUserAdminPanelActionTest {
    private DeleteUserAdminPanelAction action;

    @Before
    public void setUp() throws ServiceException {
        action = new DeleteUserAdminPanelAction();
        action.setUserId(1);
        User user = new CurrentUserService().getCurrentUserEntity();
        user.setIsAdmin(true);
    }

    @Test
    public void execute() throws ServiceException {
        assertEquals(Action.SUCCESS, action.execute());
    }
}
