package model.dao;

import model.entity.Resume;
import model.entity.WorkExperience;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class WorkExperienceDao extends HibernateDao {

    public void addWorkExperience(Resume resume, WorkExperience workExperience) {
        session.beginTransaction();

        resume.getWorkExperiences().add(workExperience);

        session.getTransaction().commit();
    }

    public void deleteWorkExperience(int workExperienceId) {
        session.beginTransaction();
        Query query = session.createQuery("delete WorkExperience where id = :workExperienceId");
        query.setParameter("workExperienceId", workExperienceId);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    public void modifyWorkExperience(int workExperienceId, String companyName, String position,
                                     String startDate, String endDate, String description) {
        session.beginTransaction();

        WorkExperience workExperience = session.get(WorkExperience.class, workExperienceId);
        workExperience.setCompanyName(companyName);
        workExperience.setPosition(position);
        workExperience.setStartDate(startDate);
        workExperience.setEndDate(endDate);
        workExperience.setDescription(description);

        session.getTransaction().commit();
    }

    public WorkExperience getWorkExperience(int workExperienceId) {
        return session.get(WorkExperience.class, workExperienceId);
    }

    public List<WorkExperience> getWorkExperiences(Resume resume) {
        Criteria criteria = session.createCriteria(WorkExperience.class);
        criteria.add(Restrictions.eq("resume", resume));
        return criteria.list();
    }
    
}
