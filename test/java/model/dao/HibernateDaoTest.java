package  model.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class HibernateDaoTest {

    private HibernateDao hibernateDao;

    @Before
    public void setUp() throws Exception {
        hibernateDao = new HibernateDao();
    }

    @Test
    public void getSession() throws Exception {
        assertNotNull(hibernateDao.session);
    }
}