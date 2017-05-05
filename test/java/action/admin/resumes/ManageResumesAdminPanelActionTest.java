package test.action.admin.resumes;

import action.admin.resumes.DownloadResumesReportAction;
import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ManageResumesAdminPanelActionTest {
    private DownloadResumesReportAction action;

    @Before
    public void setUp(){
        action = new DownloadResumesReportAction();
    }

    @Test
    public void execute(){
        try {
            assertEquals(Action.SUCCESS, action.execute());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
