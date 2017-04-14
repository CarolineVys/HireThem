package model.dao;

import model.entity.Education;
import model.entity.Resume;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class EducationDao extends HibernateDao {

    public void addEducation(Resume resume, Education education) {
        session.beginTransaction();

        resume.getEducations().add(education);

        session.getTransaction().commit();
    }

    public void deleteEducation(int educationId) {
        session.beginTransaction();
        Query query = session.createQuery("delete Education where id = :educationId");
        query.setParameter("educationId", educationId);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    public void modifyEducation(int educationId, String university, String startDate, String endDate,
                                String specialty, String degree, String description) {
        session.beginTransaction();

        Education education = session.get(Education.class, educationId);
        education.setUniversity(university);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setSpecialty(specialty);
        education.setDegree(degree);
        education.setDescription(description);

        session.getTransaction().commit();
    }

    public Education getEducation(int educationId) {
        return session.get(Education.class, educationId);
    }

    public List<Education> getEducations(Resume resume) {
        Criteria criteria = session.createCriteria(Education.class);
        criteria.add(Restrictions.eq("resume", resume));
        return criteria.list();
    }

}
