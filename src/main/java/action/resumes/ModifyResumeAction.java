package action.resumes;

import action.interceptor.AuthorizeAs;
import model.entity.Education;
import model.entity.Resume;
import model.entity.User;
import model.entity.WorkExperience;
import model.service.*;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;

import java.util.Date;
import java.util.Locale;

@AuthorizeAs(userType = "EMPLOYEE")
public class ModifyResumeAction extends ActionSupport {

    protected int resumeId;
    protected int educationId;
    protected int workExperienceId;

    protected String summary;
    protected String interests;
    protected String references;
    protected String description;
    protected String skills;

    protected String degree;
    protected String specialty;
    protected String university;
    protected String educationStartDate;
    protected String educationEndDate;
    protected String educationDescription;

    protected String companyName;
    protected String position;
    protected String workExperienceStartDate;
    protected String workExperienceEndDate;
    protected String workExperienceDescription;

    public String input() {
        Resume resume = new ResumeService().getResume(resumeId);
        new SessionService().put("resumeId", resumeId);
        summary = resume.getSummary();
        interests = resume.getInterests();
        references = resume.getReferences();
        description = resume.getDescription();
        skills = resume.getSkills();
        if (!resume.getEducations().isEmpty()) {
            Education education = (Education) resume.getEducations().toArray()[0];
            degree = education.getDegree();
            specialty = education.getSpecialty();
            university = education.getUniversity();
            educationStartDate = education.getStartDate();
            educationEndDate = education.getEndDate();
            educationDescription = education.getDescription();
        }
        if (!resume.getWorkExperiences().isEmpty()) {
            WorkExperience workExperience = (WorkExperience) resume.getWorkExperiences().toArray()[0];
            companyName = workExperience.getCompanyName();
            position = workExperience.getPosition();
            workExperienceStartDate = workExperience.getStartDate();
            workExperienceEndDate = workExperience.getEndDate();
            workExperienceDescription = workExperience.getDescription();
        }
        return INPUT;
    }

    public String execute() {
        resumeId = (int) new SessionService().getValue("resumeId");
        educationId = ((Education) new ResumeService().getResume(resumeId).getEducations().toArray()[0]).getId();
        workExperienceId = ((WorkExperience) new ResumeService().getResume(resumeId).getWorkExperiences().toArray()[0]).getId();
        new ResumeService().modifyResume(resumeId, summary, description, skills, interests, references);
        if (StringUtils.isNotBlank(university)) {
            new EducationsService().modifyEducation(educationId, university, educationStartDate, educationEndDate,
                    specialty, degree, educationDescription);
        }
        if (StringUtils.isNotBlank(companyName) && StringUtils.isNotBlank(position)) {
            new WorkExperienceService().modifyWorkExperience(workExperienceId, companyName, position,
                    workExperienceStartDate, workExperienceEndDate, workExperienceDescription);
        }
        return SUCCESS;
    }

    public void validate() {
        if (StringUtils.isEmpty(summary)) {
            addActionError("Summary cannot be empty");
        }

        /*if (StringUtils.isNotBlank(university)) {
            if (!GenericValidator.isDate(educationStartDate, Locale.forLanguageTag("ru")) ||
                    !GenericValidator.isDate(educationEndDate, Locale.forLanguageTag("ru"))) {
                addActionError("Work experience date is in wrong format");
                if (new Date(educationEndDate).before(new Date(educationStartDate))) {
                    addActionError("Work experience end date is before start date");
                }
            }
        }

        if (StringUtils.isNotBlank(companyName) && StringUtils.isNotBlank(position)) {
            if (!GenericValidator.isDate(workExperienceEndDate, Locale.forLanguageTag("ru")) ||
                    !GenericValidator.isDate(workExperienceStartDate, Locale.forLanguageTag("ru"))) {
                addActionError("Work experience date is in wrong format");
                if (new Date(workExperienceEndDate).before(new Date(workExperienceStartDate))) {
                    addActionError("Work experience end date is before start date");
                }
            }
        }
        */
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public int getWorkExperienceId() {
        return workExperienceId;
    }

    public void setWorkExperienceId(int workExperienceId) {
        this.workExperienceId = workExperienceId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getEducationStartDate() {
        return educationStartDate;
    }

    public void setEducationStartDate(String educationStartDate) {
        this.educationStartDate = educationStartDate;
    }

    public String getEducationEndDate() {
        return educationEndDate;
    }

    public void setEducationEndDate(String educationEndDate) {
        this.educationEndDate = educationEndDate;
    }

    public String getEducationDescription() {
        return educationDescription;
    }

    public void setEducationDescription(String educationDescription) {
        this.educationDescription = educationDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkExperienceStartDate() {
        return workExperienceStartDate;
    }

    public void setWorkExperienceStartDate(String workExperienceStartDate) {
        this.workExperienceStartDate = workExperienceStartDate;
    }

    public String getWorkExperienceEndDate() {
        return workExperienceEndDate;
    }

    public void setWorkExperienceEndDate(String workExperienceEndDate) {
        this.workExperienceEndDate = workExperienceEndDate;
    }

    public String getWorkExperienceDescription() {
        return workExperienceDescription;
    }

    public void setWorkExperienceDescription(String workExperienceDescription) {
        this.workExperienceDescription = workExperienceDescription;
    }

    public User getCurrentUser() {
        try {
            return new CurrentUserService().getCurrentUserEntity();
        } catch (ServiceException ignored) {
            return null;
        }
    }


}
