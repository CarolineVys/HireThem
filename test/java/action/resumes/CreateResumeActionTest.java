package test.action.resumes;


import action.resumes.CreateResumeAction;
import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CreateResumeActionTest {
    private CreateResumeAction action;

    @Before
    public void setUp(){
        action = new CreateResumeAction();
        action.setSummary("newSummary");
        action.setDescription("newDescription");
        action.setSkills("newSkills");
        action.setInterests("newInterests");
        action.setReferences("newRferences");

        action.setUniversity("newUni");
        action.setEducationStartDate("01.09.2017");
        action.setEducationEndDate("31.05.2021");
        action.setSpecialty("newSpec");
        action.setDegree("newDegree");
        action.setEducationDescription("newDesc");

        action.setCompanyName("newComp");
        action.setPosition("newPos");
        action.setWorkExperienceStartDate("01.09.2017");
        action.setWorkExperienceEndDate("31.05.2021");
        action.setWorkExperienceDescription("newDescr");
    }

    @Test
    public void execute(){
        assertEquals(Action.SUCCESS, action.execute());
    }
}
