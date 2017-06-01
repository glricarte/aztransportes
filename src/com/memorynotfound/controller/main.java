package com.memorynotfound.controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Dao.HibernateUtil;
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
		Motorista moto2 = new Motorista("01","01","01","01",true);
		Usuario user1 = new Usuario("00","00",true); 
		Usuario user2 = new Usuario("01","01",true); 
		Autorizacao aut1 = new Autorizacao("ROLE_ADMIN");
		
	    Semana sem1 = new Semana("00","00","00","00","00","00","00",new Date());
	    Semana sem2 = new Semana("01","01","01","01","01","01","01",new Date());
	    Semana sem3 = new Semana("03","01","01","01","01","01","01",new Date());

	   Resumo res1 = new Resumo("99","00","00",new Date());
	    
	    user1.addAutorizacao(aut1);
	    user2.addAutorizacao(aut1);
	     
	    user1.setMotorista(moto1);
	    user2.setMotorista(moto2);	    
	    
	    sem1.setMotorista(moto1);
	    sem2.setMotorista(moto1);
        sem3.setMotorista(moto2);
        
        res1.setMotorista(moto1);
        res1.setDetalhes(sem1);
        
        
	    Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        
	        session.persist(aut1);
	        session.persist(moto1);
	        session.persist(user1);
	        session.persist(moto2);
	      session.persist(user2);
	      session.persist(sem1);
	      session.persist(sem2);
	      session.persist(sem3);
	      
	      session.persist(res1);
	       session.getTransaction().commit();
	        session.close();  
	    }
		
	
}