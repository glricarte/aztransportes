package Controller;
import Dao.MotoristaDao;
import Dao.MotoristaDaoImp;
import Model.Motorista;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class MotoristaController {

private Motorista motorista;
private DataModel listaMotoristas;

public DataModel getListarMotoristas() {
List<Motorista> lista = new MotoristaDaoImp().list();
listaMotoristas = new ListDataModel(lista);
return listaMotoristas;
}
public Motorista getMotorista() {
return motorista;
}
public void setMotorista(Motorista motorista) {
this.motorista = motorista;
}
public String prepararAdicionarMotorista(){
motorista = new Motorista();
return "gerenciarMotorista";
}
public String prepararAlterarMotorista(){
motorista = (Motorista)(listaMotoristas.getRowData());
return "gerenciarMotorista";
}
public String excluirMotorista(){
Motorista MotoristaTemp = (Motorista)(listaMotoristas.getRowData());
MotoristaDao dao = new MotoristaDaoImp();
dao.remove(MotoristaTemp);
return "index";
}
public String adicionarMotorista(){
MotoristaDao dao = new MotoristaDaoImp();
dao.save(motorista);
return "index";
}
public String alterarMotorista(){
MotoristaDao dao = new MotoristaDaoImp();
dao.update(motorista);
return "index";
}
}



