package Dao;
import java.util.List;

import javax.faces.model.DataModel;

import Model.Resumo;
import Model.Semana;

public interface ResumoDao {

	public void save(Resumo resumo);
	public Resumo getResumo(long id);
	public List<Resumo> list(String sql,List<Semana> semana);
	public void remove(Resumo resumo);
	public void update(Resumo resumo);
}
