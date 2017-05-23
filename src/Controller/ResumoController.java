package Controller;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import Dao.ResumoDao;
import Dao.ResumoDaoImp;
import Model.Resumo;

@ManagedBean
@SessionScoped
public class ResumoController  implements Serializable {
 
private Resumo resumo;
private DataModel<Resumo> listaResumos;
String username;


public DataModel<Resumo> getListarResumos() {
username=((SecurityContext) SecurityContextHolder.getContext()).getAuthentication().getName();
List<Resumo> lista = new ResumoDaoImp().list(username);
listaResumos = new ListDataModel<Resumo>(lista);
return listaResumos;
}
 
public Resumo getResumo() {
return resumo;
}
 
public void setResumo(Resumo resumo) {
this.resumo = resumo;
}
 
public void prepararAdicionarResumo(ActionEvent actionEvent){
resumo = new Resumo();
}
 
public void prepararAlterarResumo(ActionEvent actionEvent){
resumo = (Resumo)(listaResumos.getRowData());
}
 
public String excluirResumo(){
 
Resumo resumoTemp = (Resumo)(listaResumos.getRowData());
ResumoDao dao = new ResumoDaoImp();
dao.remove(resumoTemp);
return "index";
 
}
 
public void adicionarResumo(ActionEvent actionEvent){
 
ResumoDao dao = new ResumoDaoImp();
dao.save(resumo);
 
}
 
public void alterarResumo(ActionEvent actionEvent){
 
		ResumoDao dao = new ResumoDaoImp();
dao.update(resumo);
 
}
 
}