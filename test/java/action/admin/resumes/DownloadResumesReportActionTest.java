package action.admin.resumes;

import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DownloadResumesReportActionTest {
    private DownloadResumesReportAction action;

    @Before
    public void setUp() throws Exception{
        action = new DownloadResumesReportAction();
    }

    @Test
    public void downloadPdf(){
        assertEquals(Action.SUCCESS,action.downloadPdf());
    }

    @Test
    public void downloadCsv(){
        assertEquals(Action.SUCCESS,action.downloadCsv());
    }

    @Test
    public void downloadXls(){
        assertEquals(Action.SUCCESS,action.downloadXls());
    }
}
