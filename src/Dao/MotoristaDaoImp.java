package Dao;

import Model.Motorista;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MotoristaDaoImp implements MotoristaDao {

public void save(Motorista motorista) {
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction t = session.beginTransaction();
session.save(motorista);
t.commit();
}
public Motorista getMotorista(long id) {
Session session = HibernateUtil.getSessionFactory().openSession();
return (Motorista) session.load(Motorista.class, id);
}
public List<Motorista> list() {
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction t = session.beginTransaction();
List lista = session.createQuery("from motorista").list();
t.commit();
return lista;
}
public void remove(Motorista motorista) {
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction t = session.beginTransaction();
session.delete(motorista);
t.commit();
}
public void update(Motorista motorista) {
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction t = session.beginTransaction();
session.update(motorista);
t.commit();
}
}
