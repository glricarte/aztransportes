package Dao;

import java.util.List;

import javax.faces.model.DataModel;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import Model.Resumo;
import Model.Semana;

public class ResumoDaoImp implements ResumoDao {

	public void save(Resumo resumo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(resumo);
		t.commit();
	}

	public Resumo getResumo(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Resumo) session.load(Resumo.class, id);
	}

	public List<Resumo> list(String sql,List<Semana> semana) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Criteria cr = session.createCriteria(Resumo.class,"sem");
		
		Query query = session.createQuery("select motorista.cpf from Usuario where username = :nome");
		query.setParameter("nome", sql);
	
		cr.add(Restrictions.like("sem.motorista.cpf", (String) query.uniqueResult(), MatchMode.EXACT));
		cr.add(Restrictions.in("sem.detalhes", semana));
		
		List<Resumo> lista = cr.list();
		
		
	
		return lista;
	}

	public void remove(Resumo resumo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(resumo);
		t.commit();
	}

	public void update(Resumo resumo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(resumo);
		t.commit();
	}
}
