package test.action.resumes;

import action.resumes.BrowseResumesAction;
import com.opensymphony.xwork2.Action;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BrowseResumesActionTest {
    private BrowseResumesAction action;

    @Before
    public void setUp(){
        action = new BrowseResumesAction();
        action.setSummaryToSearch("summary");
        action.setSkillsToSearch("cool skills");
        action.setEducationToSearch("school");
        action.setExperienceToSearch("position");
    }

    @Test
    public void input() {
        assertEquals(Action.INPUT, action.input());
    }
    @Test
    public void searchBySummary(){
        assertEquals(Action.SUCCESS, action.searchBySummary());
    }

    @Test
    public void searchBySkills(){
        assertEquals(Action.SUCCESS, action.searchBySkills());
    }

    @Test
    public void searchByEducation(){
        assertEquals(Action.SUCCESS, action.searchByEducation());
    }

    @Test
    public void searchByExperience(){
        assertEquals(Action.SUCCESS, action.searchByExperience());
    }
}
