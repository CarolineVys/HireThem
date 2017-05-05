package model.util;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class CsvGenerationUtilTest {

    @Before
    public void setUp() throws Exception {
        new File("test").mkdir();
    }

    @Test
    public void getVacanciesListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\vacancies-report.csv");
        CsvGenerationUtil.generateVacanciesInCSV().writeTo(stream);
    }

    @Test
    public void getUsersListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\users-report.csv");
        CsvGenerationUtil.generateUsersInCSV().writeTo(stream);
    }

    @Test
    public void getResumesListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\resumes-report.csv");
        CsvGenerationUtil.generateResumesInCSV().writeTo(stream);
    }

    @Test
    public void getResumeListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\test-resume.csv");
        CsvGenerationUtil.generateResumeInCSV(475).writeTo(stream);
    }

    @Test
    public void getVacancyListReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\test-vacancy.csv");
        CsvGenerationUtil.generateVacancyInCSV(166).writeTo(stream);
    }

}
