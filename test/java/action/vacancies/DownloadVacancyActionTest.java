package action.vacancies;

import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DownloadVacancyActionTest {
    private DownloadVacancyAction action;

    @Before
    public void setUp(){
        action = new DownloadVacancyAction();
        action.setVacancyId(1);
    }

    @Test
    public void downloadPdf(){
        assertEquals(Action.SUCCESS, action.downloadPdf());
    }

    @Test
    public void downloadCsv(){
        assertEquals(Action.SUCCESS, action.downloadCsv());
    }

    @Test
    public void downloadXls(){
        assertEquals(Action.SUCCESS, action.downloadXls());
    }
}
