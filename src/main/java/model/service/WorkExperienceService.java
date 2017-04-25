package model.service;

import model.dao.WorkExperienceDao;
import model.entity.Resume;
import model.entity.WorkExperience;
import model.service.exception.ServiceException;

import java.util.List;

public class WorkExperienceService {

    private ResumeService resumeService = new ResumeService();

    private WorkExperienceDao workExperienceDao = new WorkExperienceDao();

    public void createWorkExperience(int resumeId, String companyName, String position,
                                     String startDate, String endDate, String description) throws ServiceException {
        WorkExperience workExperience = new WorkExperience();
        workExperience.setCompanyName(companyName);
        workExperience.setPosition(position);
        workExperience.setStartDate(startDate);
        workExperience.setEndDate(endDate);
        workExperience.setDescription(description);

        Resume resume = resumeService.getResume(resumeId);

        workExperience.setResume(resume);

        workExperienceDao.addWorkExperience(resume, workExperience);
    }

    public void modifyWorkExperience(int resumeId, String companyName, String position,
                                     String startDate, String endDate, String description) {
        workExperienceDao.modifyWorkExperience(resumeId, companyName, position,
                startDate, endDate, description);
    }

    public WorkExperience getWorkExperience(int workExperienceId) {
        return workExperienceDao.getWorkExperience(workExperienceId);
    }

    public List<WorkExperience> getWorkExperiences(int resumeId) {
        return workExperienceDao.getWorkExperiences(resumeService.getResume(resumeId));
    }

    public void deleteWorkExperience(int workExperienceId) {
        workExperienceDao.deleteWorkExperience(workExperienceId);
    }

}
