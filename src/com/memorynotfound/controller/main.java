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
	}
}