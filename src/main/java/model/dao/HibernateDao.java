package model.dao;

import model.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateDao {

    protected Session session = HibernateUtil.getSession();

}
