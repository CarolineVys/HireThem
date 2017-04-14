package model.dao;

import model.entity.Resume;
import model.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;

import java.util.List;

public class ResumeDao extends HibernateDao {

    public void addResume(User user, Resume resume) {
        session.beginTransaction();

        user.getResumes().add(resume);

        session.getTransaction().commit();
    }

    public void deleteResume(int resumeId) {
        session.beginTransaction();
        Query query = session.createQuery("delete Resume where id = :resumeId");
        query.setParameter("resumeId", resumeId);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    public void modifyResume(int resumeId, String summary, String description, String skills,
                             String interests, String references) {
        session.beginTransaction();

        Resume resume = session.get(Resume.class, resumeId);
        resume.setSummary(summary);
        resume.setDescription(description);
        resume.setSkills(skills);
        resume.setInterests(interests);
        resume.setReferences(references);

        session.getTransaction().commit();
    }

    public Resume getResume(int resumeId) {
        return session.get(Resume.class, resumeId);
    }

    public List<Resume> getResumes(User user) {
        session.beginTransaction();

        Query query = session.createQuery("select r from Resume r where employee.id = :id");
        query.setParameter("id", user.getId());
        List<Resume> result = (List<Resume>) query.list();

        session.getTransaction().commit();
        return result;
    }

    public List<Resume> getAllResumes() {
        Criteria criteria = session.createCriteria(Resume.class);
        return criteria.list();
    }

}
