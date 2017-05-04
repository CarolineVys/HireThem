package model.util;

import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by egorshulga on 01-May-16.
 */
public class HibernateUtilTest {

    Session session;

    @Test
    public void getSession() throws Exception {
        session = HibernateUtil.getSession();
        assertNotNull(session);
    }

}