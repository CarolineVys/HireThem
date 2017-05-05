package model.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VacancyTest {

    private Vacancy vacancy;

    private User employer;
    private String title = "Meow";
    private String summary = "Woof";
    private String description = "Moo";
    private String salary = "Bulb";
    private String requiredExperience = "Trick";
    private String requiredSkills = "Crick";
    private String contactInfo = "Crock";


    @Before
    public void setUp() throws Exception {
        vacancy = new Vacancy();
        vacancy.setEmployer(new User());
        vacancy.setSummary(summary);
        vacancy.setDescription(description);
        vacancy.setSalary(salary);
        vacancy.setTitle(title);
        vacancy.setRequiredSkills(requiredSkills);
        vacancy.setRequiredExperience(requiredExperience);
    }

    @Test
    public void getId() throws Exception {
        assertNotNull(vacancy.getId());
    }

    @Test
    public void getEmployer() throws Exception {
        assertNotNull(vacancy.getEmployer());
    }


    @Test
    public void getSummary() throws Exception {
        assertEquals(vacancy.getSummary(), summary);
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals(vacancy.getDescription(), description);
    }

    @Test
    public void getSalary() throws Exception {
        assertEquals(vacancy.getSalary(), salary);
    }

    @Test
    public void getTitle() throws Exception {
        assertEquals(vacancy.getTitle(), title);
    }

    @Test
    public void setRequiredSkills() throws Exception {
        assertEquals(vacancy.getRequiredSkills(), requiredSkills);
    }

    @Test
    public void getRequiredExperience() throws Exception {
        assertEquals(vacancy.getRequiredExperience(), requiredExperience);
    }

}
