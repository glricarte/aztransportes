package com.memorynotfound.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Model.Autorizacao;
import Model.Motorista;
import Model.Resumo;
import Model.Semana;
import Model.Usuario;

public class main {

	public static void main(String[] arg) {
		try {
			AnnotationConfiguration ac = new AnnotationConfiguration();
			ac.addAnnotatedClass(Motorista.class);
			ac.addAnnotatedClass(Autorizacao.class);
			ac.addAnnotatedClass(Usuario.class);
			ac.addAnnotatedClass(Resumo.class);
			ac.addAnnotatedClass(Semana.class);
			SessionFactory sessionFactory = ac.configure()
					.buildSessionFactory();
			SchemaExport se = new SchemaExport(ac);
			se.create(true, true);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Motorista moto1 = new Motorista("00","00","00","00",true);
		Usuario user1 = new Usuario("00","00",true); 
		Autorizacao aut1 = new Autorizacao("ROLE_ADMIN");
		
	    user1.
	        student1.setUniversity(university);
	        student2.setUniversity(university);
	        student3.setUniversity(university);
	 
	 
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	 
	        session.persist(university);
	        session.persist(student1);
	        session.persist(student2);
	        session.persist(student3);
	         
	        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
	        for(Student s: students){
	            System.out.println("Details : "+s);
	            System.out.println("Student University Details: "+s.getUniversity());
	        }
	         
	        session.getTransaction().commit();
	        session.close();  
	    }
		
	}
}