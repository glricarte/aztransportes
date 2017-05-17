package Dao;
import java.util.List;

import Model.Motorista;

public interface MotoristaDao {

	public void save(Motorista motorista);
	public Motorista getMotorista(long id);
	public List<Motorista> list();
	public void remove(Motorista motorista);
	public void update(Motorista motorista);
}
