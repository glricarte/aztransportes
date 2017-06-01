package Controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import Dao.SemanaDao;
import Dao.SemanaDaoImp;
import Model.Semana;

@ManagedBean
@SessionScoped
public class SemanaController  implements Serializable {
 
private Semana semana;
private DataModel<Semana> listaSemanas;
String username;
@PostConstruct
public void init() {
    //initialize the data here
    this.semana = new Semana();
    //similar for other fields
}
public List<Semana> getListarSemanas(String semana) {

username=((SecurityContext) SecurityContextHolder.getContext()).getAuthentication().getName();
List<Semana> lista = new SemanaDaoImp().list(username,semana);
listaSemanas = new ListDataModel<Semana>(lista);
return lista;
}
 
public Semana getSemana() {
return semana;
}
 
public void setSemana(Semana semana) {
this.semana = semana;
}
 
public void prepararAdicionarSemana(ActionEvent actionEvent){
semana = new Semana();
}
 
public void prepararAlterarSemana(ActionEvent actionEvent){
semana = (Semana)(listaSemanas.getRowData());
}
 
public String excluirSemana(){
 
Semana semanaTemp = (Semana)(listaSemanas.getRowData());
SemanaDao dao = new SemanaDaoImp();
dao.remove(semanaTemp);
return "index";
 
}
 
public void adicionarSemana(ActionEvent actionEvent){
 
SemanaDao dao = new SemanaDaoImp();
dao.save(semana);
 
}
 
public void alterarSemana(ActionEvent actionEvent){
 
		SemanaDao dao = new SemanaDaoImp();
dao.update(semana);
 
}
 
}