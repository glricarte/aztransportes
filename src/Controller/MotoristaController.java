package Controller;
import Dao.MotoristaDao;
import Dao.MotoristaDaoImp;
import Model.Motorista;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class MotoristaController  implements Serializable {
 
private Motorista motorista;
private DataModel<Motorista> listaMotoristas;
 
public DataModel<Motorista> getListarMotoristas() {
List<Motorista> lista = new MotoristaDaoImp().list();
listaMotoristas = new ListDataModel<Motorista>(lista);
return listaMotoristas;
}
 
public Motorista getMotorista() {
return motorista;
}
 
public void setMotorista(Motorista motorista) {
this.motorista = motorista;
}
 
public void prepararAdicionarMotorista(ActionEvent actionEvent){
motorista = new Motorista();
}
 
public void prepararAlterarMotorista(ActionEvent actionEvent){
motorista = (Motorista)(listaMotoristas.getRowData());
}
 
public String excluirMotorista(){
 
Motorista motoristaTemp = (Motorista)(listaMotoristas.getRowData());
MotoristaDao dao = new MotoristaDaoImp();
dao.remove(motoristaTemp);
return "index";
 
}
 
public void adicionarMotorista(ActionEvent actionEvent){
 
MotoristaDao dao = new MotoristaDaoImp();
dao.save(motorista);
 
}
 
public void alterarMotorista(ActionEvent actionEvent){
 
MotoristaDao dao = new MotoristaDaoImp();
dao.update(motorista);
 
}
 
}