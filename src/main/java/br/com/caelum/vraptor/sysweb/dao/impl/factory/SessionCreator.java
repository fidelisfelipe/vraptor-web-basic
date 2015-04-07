package br.com.caelum.vraptor.sysweb.dao.impl.factory;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import org.hibernate.Session;

/**
 * @author fidelis.guimaraes
 *
 */
public class SessionCreator {

    @Produces
    public Session getSession() {
        return SessionUtil.getSessionFactory().openSession();
    }

    public void close(@Disposes Session session) {
        if (session.isOpen()) {
            session.close();
        }
    }
}
