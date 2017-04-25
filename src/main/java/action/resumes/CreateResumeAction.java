package action.resumes;

import action.interceptor.AuthorizeAs;
import model.entity.User;
import model.service.CurrentUserService;
import model.service.EducationsService;
import model.service.ResumeService;
import model.service.WorkExperienceService;
import model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;

import java.util.Date;
import java.util.Locale;

@AuthorizeAs(userType = "EMPLOYEE")
public class CreateResumeAction extends ActionSupport {

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


    public String execute() {
        ResumeService resumeService = new ResumeService();
        try {
            int userId = new CurrentUserService().getCurrentUserId();
            resumeService.createResume(userId, summary, description, skills, interests, references);
            int resumeId = resumeService.findResumesUsingSummary(summary).get(0).getId();
            if (StringUtils.isNotBlank(university)) {
                new EducationsService().createEducation(resumeId, university, educationStartDate, educationEndDate,
                        specialty, degree, educationDescription);
            }
            if (StringUtils.isNotBlank(companyName) && StringUtils.isNotBlank(position)) {
                new WorkExperienceService().createWorkExperience(resumeId, companyName, position,
                        workExperienceStartDate, workExperienceEndDate, workExperienceDescription);
            }
        } catch (ServiceException ignored) {
            return INPUT;
        }
        return SUCCESS;
    }

    public void validate() {
        if (StringUtils.isEmpty(summary)) {
            addActionError("Summary cannot be empty");
        }
        /*if (StringUtils.isNotBlank(university)) {
            if (!GenericValidator.isDate(educationEndDate, Locale.forLanguageTag("ru")) ||
                    !GenericValidator.isDate(educationStartDate, Locale.forLanguageTag("ru"))) {
                addActionError("Education date is in wrong format");
                if (new Date(educationEndDate).before(new Date(educationStartDate))) {
                    addActionError("Education end date is before start date");
                }
            }
        }
        if (StringUtils.isNotBlank(companyName) && StringUtils.isNotBlank(position)) {
            if (!GenericValidator.isDate(workExperienceStartDate, Locale.forLanguageTag("ru")) ||
                    !GenericValidator.isDate(workExperienceEndDate, Locale.forLanguageTag("ru"))) {
                addActionError("Work experience date is in wrong format");
                if (new Date(workExperienceEndDate).before(new Date(workExperienceStartDate))) {
                    addActionError("Work experience end date is before start date");
                }
            }
        }
        */
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
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
