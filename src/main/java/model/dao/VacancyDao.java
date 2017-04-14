package model.dao;

import model.entity.User;
import model.entity.Vacancy;
import org.hibernate.Criteria;
import org.hibernate.Query;

import java.util.List;

public class VacancyDao extends HibernateDao {

    public void addVacancy(User user, Vacancy vacancy) {
        session.beginTransaction();

        user.getVacancies().add(vacancy);

        session.getTransaction().commit();
    }

    public void deleteVacancy(int vacancyId) {
        session.beginTransaction();
        Query query = session.createQuery("delete Vacancy where id = :vacancyId");
        query.setParameter("vacancyId", vacancyId);
        int result = query.executeUpdate();
        session.getTransaction().commit();
    }

    public void modifyVacancy(int vacancyId, String title, String summary, String description,
                              String salary, String requiredExperience, String requiredSkills) {
        session.beginTransaction();

        Vacancy vacancy = session.get(Vacancy.class, vacancyId);
        vacancy.setTitle(title);
        vacancy.setSummary(summary);
        vacancy.setDescription(description);
        vacancy.setSalary(salary);
        vacancy.setRequiredExperience(requiredExperience);
        vacancy.setRequiredSkills(requiredSkills);

        session.getTransaction().commit();
    }

    public Vacancy getVacancy(int vacancyId) {
        return session.get(Vacancy.class, vacancyId);
    }

    public List<Vacancy> getVacancies(User user) {
        session.beginTransaction();

        Query query = session.createQuery("select r from Vacancy r where employer.id = :id");
        query.setParameter("id", user.getId());
        List<Vacancy> result = (List<Vacancy>) query.list();

        session.getTransaction().commit();
        return result;
    }

    public List<Vacancy> getAllVacancies() {
        Criteria criteria = session.createCriteria(Vacancy.class);
        return criteria.list();
    }
}
