package test.action.resumes;

import action.resumes.ManageResumesAction;
import com.opensymphony.xwork2.Action;
import model.entity.User;
import model.util.PasswordEncryptionService;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ManageResumesActionTest {
    private ManageResumesAction action;

    @Before
    public void setUp(){
        action = new ManageResumesAction();
    }

    public void execute(){
        assertEquals(Action.SUCCESS, action.execute());
    }
}
