package model.util;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class XlsGenerationUtilTest {
    @Before
    public void setUp() throws Exception {
        new File("test").mkdir();
    }

    @Test
    public void getVacanciesListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\vacancies-report.xls");
        XlsGenerationUtil.generateVacanciesInXls().writeTo(stream);
    }

    @Test
    public void getUsersReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\users-report.xls");
        XlsGenerationUtil.generateUsersInXls().writeTo(stream);
    }

    @Test
    public void getResumesReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\resumes-report.xls");
        XlsGenerationUtil.generateResumesInXls().writeTo(stream);
    }

    @Test
    public void getResumeReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\test-resume.xls");
        XlsGenerationUtil.generateResumeInXls(475).writeTo(stream);
    }

    @Test
    public void getVacancyReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\test-vacancy.xls");
        XlsGenerationUtil.generateVacancyInXls(166).writeTo(stream);
    }
}
