package model.service;

import model.dao.ResumeDao;
import model.entity.Resume;
import model.entity.User;
import model.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResumeService {

    private UserService userService = new UserService();

    private ResumeDao resumeDao = new ResumeDao();

    public void createResume(int userId, String summary, String description, String skills, String interests,
                             String references) throws ServiceException {
        Resume resume = new Resume();
        resume.setSummary(summary);
        resume.setDescription(description);
        resume.setSkills(skills);
        resume.setInterests(interests);
        resume.setReferences(references);

        User currentUser = userService.getUser(userId);

        resume.setEmployee(currentUser);

        resumeDao.addResume(currentUser, resume);
    }

    public void modifyResume(int resumeId, String summary, String description, String skills, String interests,
                             String references) {
        resumeDao.modifyResume(resumeId, summary, description, skills, interests, references);
    }

    public Resume getResume(int resumeId) {
        return resumeDao.getResume(resumeId);
    }

    public List<Resume> getResumes(int userId) throws ServiceException {
        return resumeDao.getResumes(userService.getUser(userId));
    }

    public void deleteResume(int resumeId) {
        resumeDao.deleteResume(resumeId);
    }

    public List<Resume> findResumesUsingSummary(String searchText) {
        return resumeDao.getAllResumes().stream()
                .filter(resume -> StringUtils.containsIgnoreCase(resume.getSummary(), searchText))
                .collect(Collectors.toList());
    }

    public List<Resume> findResumesUsingDescription(String searchText) {
        return resumeDao.getAllResumes().stream()
                .filter(resume -> StringUtils.containsIgnoreCase(resume.getDescription(), searchText))
                .collect(Collectors.toList());
    }

    public List<Resume> findResumesUsingSkills(String searchText) {
        return resumeDao.getAllResumes().stream()
                .filter(resume -> StringUtils.containsIgnoreCase(resume.getSkills(), searchText))
                .collect(Collectors.toList());
    }

    public List<Resume> findResumesUsingInterests(String searchText) {
        return resumeDao.getAllResumes().stream()
                .filter(resume -> StringUtils.containsIgnoreCase(resume.getInterests(), searchText))
                .collect(Collectors.toList());
    }

    public List<Resume> getAllResumes() {
        return resumeDao.getAllResumes();
    }

    public List<Resume> findResumesUsingEducation(String educationToSearch) {
        List<Resume> result = new ArrayList<>();
        for (Resume resume : resumeDao.getAllResumes()) {
            result.addAll(resume.getEducations().stream().filter(education ->
                    StringUtils.containsIgnoreCase(education.getUniversity(), educationToSearch) ||
                            StringUtils.containsIgnoreCase(education.getDegree(), educationToSearch) ||
                            StringUtils.containsIgnoreCase(education.getSpecialty(), educationToSearch))
                    .map(education -> resume).collect(Collectors.toList()));
        }
        return result;
    }

    public List<Resume> findResumesUsingWorkExperience(String educationToSearch) {
        List<Resume> result = new ArrayList<>();
        for (Resume resume : resumeDao.getAllResumes()) {
            result.addAll(resume.getWorkExperiences().stream().filter(experience ->
                    StringUtils.containsIgnoreCase(experience.getCompanyName(), educationToSearch) ||
                            StringUtils.containsIgnoreCase(experience.getPosition(), educationToSearch) ||
                            StringUtils.containsIgnoreCase(experience.getDescription(), educationToSearch))
                    .map(education -> resume).collect(Collectors.toList()));
        }
        return result;
    }
}
