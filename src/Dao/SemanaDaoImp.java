package Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import Model.Resumo;
import Model.Semana;
import Model.Usuario;

public class SemanaDaoImp implements SemanaDao {

	public void save(Semana semana) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(semana);
		t.commit();
	}

	public Semana getSemana(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Semana) session.load(Semana.class, id);
	}

	public List<String> listarnomesemanas(String user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Semana.class,"sem");
		
		Query query = session.createQuery("select motorista.cpf from Usuario where username = :nome");
		query.setParameter("nome", user);
	
		cr.add(Restrictions.like("sem.motorista.cpf", (String) query.uniqueResult(), MatchMode.EXACT));

		cr.setProjection(Projections.property("sem.semana"));
		List<String> listagem=cr.list();
			
		return listagem;
	}
	
	public List<Semana> list(String sql,String semana) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Semana.class,"sem");
		
		Query query = session.createQuery("select motorista.cpf from Usuario where username = :nome");
		query.setParameter("nome", sql);
	
		cr.add(Restrictions.like("sem.motorista.cpf", (String) query.uniqueResult(), MatchMode.EXACT));
		cr.add(Restrictions.like("sem.semana", semana, MatchMode.EXACT));

		List<Semana> lista = cr.list();
		
		
		return lista;
	}

	public void remove(Semana semana) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(semana);
		t.commit();
	}

	public void update(Semana semana) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(semana);
		t.commit();
	}
}
