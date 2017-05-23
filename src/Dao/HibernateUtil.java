package Dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import Model.Autorizacao;
import Model.Motorista;
import Model.Resumo;
import Model.Semana;
import Model.Usuario;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create the SessionFactory from standard (hibernate.cfg.xml)
				// config file.
				@SuppressWarnings("deprecation")
				AnnotationConfiguration ac = new AnnotationConfiguration();
				ac.addAnnotatedClass(Motorista.class);
				ac.addAnnotatedClass(Resumo.class);
				ac.addAnnotatedClass(Semana.class);
				ac.addAnnotatedClass(Usuario.class);
				ac.addAnnotatedClass(Autorizacao.class);
				sessionFactory = ac.configure().buildSessionFactory();
			} catch (Throwable ex) {
				// Log the exception.
				System.err.println("Initial SessionFactory creation failed."
						+ ex);
				throw new ExceptionInInitializerError(ex);
			}
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
}
