package action.home;

import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class IndexActionTest {
    private IndexAction action;

    @Before
    public void setUp(){
        action = new IndexAction();
    }

    @Test
    public void execute(){
        assertEquals(Action.SUCCESS, action.execute());
    }
}
