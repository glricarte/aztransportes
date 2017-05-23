package Dao;
import java.util.List;

import Model.Resumo;

public interface ResumoDao {

	public void save(Resumo resumo);
	public Resumo getResumo(long id);
	public List<Resumo> list(String sql);
	public void remove(Resumo resumo);
	public void update(Resumo resumo);
}
