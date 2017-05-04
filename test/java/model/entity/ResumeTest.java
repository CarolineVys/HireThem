package model.entity;


import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ResumeTest {
    private Resume resume;

    private String contactInfo = "Minsk, Bedy 4";
    private String summary = "Uhy";
    private String description = "I'am awesome!";
    private String interests = "Ski, football, collecting traiding cards";
    private String references = "vk.com/chudo-udo";
    private String skills = "watching serials";
    private Set<WorkExperience> workExperiences;
    private Set<Education> educations;

    @Before
    public void setUp() throws Exception {
        resume = new Resume();
        resume.setEmployee(new User());
        resume.setSummary(summary);
        resume.setDescription(description);
        resume.setInterests(interests);
        resume.setReferences(references);
        resume.setSkills(skills);
        resume.setWorkExperiences(workExperiences);
        resume.setEducations(educations);
    }

    @Test
    public void getId() throws Exception {
        assertNotNull(resume.getId());
    }

    @Test
    public void getEmployee() throws Exception {
        assertNotNull(resume.getEmployee());
    }


    @Test
    public void getSummary() throws Exception {
        assertEquals(resume.getSummary(), summary);
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals(resume.getDescription(), description);
    }

    @Test
    public void getInterests() throws Exception {
        assertEquals(resume.getInterests(), interests);
    }

    @Test
    public void getReferences() throws Exception {
        assertEquals(resume.getReferences(), references);
    }

    @Test
    public void getSkills() throws Exception {
        assertEquals(resume.getSkills(), skills);
    }

    @Test
    public void getWorkExperiences() throws Exception {
        assertEquals(resume.getWorkExperiences(), workExperiences);
    }

    @Test
    public void getEducations() throws Exception {
        assertEquals(resume.getEducations(), educations);
    }


}
