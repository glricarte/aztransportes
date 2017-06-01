package Dao;
import java.util.List;

import Model.Semana;

public interface SemanaDao {

	public void save(Semana semana);
	public Semana getSemana(long id);
	public List<Semana> list(String sql,String semana);
	public void remove(Semana semana);
	public void update(Semana semana);
	public List<String> listarnomesemanas(String user);
}
