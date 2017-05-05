package test.action.resumes;

import action.resumes.DeleteResumeAction;
import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DeleteResumeActionTest {
    private DeleteResumeAction action;

    @Before
    public void setUp(){
        action = new DeleteResumeAction();
        action.setResumeId(10);
    }

    @Test
    public void execute(){
        assertEquals(Action.SUCCESS, action.execute());
    }
}
