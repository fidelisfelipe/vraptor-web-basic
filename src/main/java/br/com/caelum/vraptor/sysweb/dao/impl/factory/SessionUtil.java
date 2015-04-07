package br.com.caelum.vraptor.sysweb.dao.impl.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
	
}
