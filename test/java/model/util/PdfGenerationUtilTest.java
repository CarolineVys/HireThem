package model.util;

import model.entity.Resume;
import model.service.ResumeService;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PdfGenerationUtilTest {

    @Before
    public void setUp() throws Exception {
        new File("test").mkdir();
    }

    @Test
    public void getResumeDocument() throws Exception {
        Resume resume = new ResumeService().getAllResumes().get(2);

        OutputStream stream = new FileOutputStream("test\\resources\\test-resume.pdf");
        PdfGenerationUtil.getResumeDocument(resume).writeTo(stream);
    }

    @Test
    public void getUsersReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\users-report.pdf");
        PdfGenerationUtil.getUsersReport().writeTo(stream);
    }

    @Test
    public void getResumesReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\resumes-report.pdf");
        PdfGenerationUtil.getResumesReport().writeTo(stream);
    }

    @Test
    public void getVacanciesReport() throws Exception {
        OutputStream stream = new FileOutputStream("test\\resources\\vacancies-report.pdf");
        PdfGenerationUtil.getVacanciesReport().writeTo(stream);
    }

}
