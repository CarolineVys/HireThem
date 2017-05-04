package model.entity;


import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WorkExperienceTest {

    private WorkExperience workExperience;

    private String companyName = "Bubliki";
    private String position = "lalala";
    private Date startDate = new Date(2013, 9, 1);
    private Date endDate = new Date(2017, 9, 1);
    private String description = "cppshechka";

    @Before
    public void setUp() throws Exception {
        workExperience = new WorkExperience();
        workExperience.setResume(new Resume());
        workExperience.setCompanyName(companyName);
        workExperience.setPosition(position);
        workExperience.setDescription(description);
        workExperience.setStartDate(startDate.toString());
        workExperience.setEndDate(endDate.toString());
    }

    @Test
    public void getId() throws Exception {
        assertNotNull(workExperience.getId());
    }

    @Test
    public void getResume() throws Exception {
        assertNotNull(workExperience.getResume());
    }

    @Test
    public void getCompanyName() throws Exception {
        assertEquals(workExperience.getCompanyName(), companyName);
    }

    @Test
    public void getPosition() throws Exception {
        assertEquals(workExperience.getPosition(), position);
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals(workExperience.getDescription(), description);
    }

    @Test
    public void getStartDate() throws Exception {
        assertEquals(workExperience.getStartDate(), startDate.toString());
    }

    @Test
    public void getEndDate() throws Exception {
        assertEquals(workExperience.getEndDate(), endDate.toString());
    }
}
