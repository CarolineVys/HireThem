package test.action.profile;

import action.profile.EditProfileAction;
import com.opensymphony.xwork2.Action;
import model.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class EditProfileActionTest {
    private EditProfileAction action;

    @Before
    public void setUp(){
        action = new EditProfileAction();
        action.setName("newName");
        action.setSurname("newSurname");
        action.setAbout("bla-bla");
        action.setContactInfo("newInfo");
        action.setNewPassword("newPass8");
    }

    @Test
    public void input() throws ServiceException {
        assertEquals(Action.INPUT, action.input());
    }

    @Test
    public void execute() {
        assertEquals(Action.SUCCESS, action.execute());
    }
}
