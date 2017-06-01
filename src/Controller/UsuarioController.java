package Controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import Dao.SemanaDaoImp;
import Model.Resumo;
import Model.Semana;
import Model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

   private Usuario usuario;
  private List<String> semanas;
  private String semana_selecionada = "";
  private List<Semana> semanas_resumo_aux=null;
  private List<Resumo> resumos_resumo_aux=null;
  
  private DataModel<Semana> semanas_resumo;
  private DataModel<Resumo> resumos_resumo;
  
 
  
  public List<String> ListartodasSemanas(){
       SecurityContext context = SecurityContextHolder.getContext();
       Authentication authentication = context.getAuthentication();
       semanas = new SemanaDaoImp().listarnomesemanas(((User)authentication.getPrincipal()).getUsername());  
       return semanas;
   }
   
   public void Atualizadados(){
	   semana_selecionada = getSemana_selecionada();
	 if(semana_selecionada.equals("")){
		 semanas_resumo=null;
		 resumos_resumo=null;
		 
	 }else{
	   
	   semanas_resumo_aux=  new SemanaController().getListarSemanas(semana_selecionada);
	   resumos_resumo_aux=  new ResumoController().getListarResumos(semanas_resumo_aux);
	   semanas_resumo = new ListDataModel<Semana>(semanas_resumo_aux);
	   resumos_resumo = new ListDataModel<Resumo>( resumos_resumo_aux);
	 }
	  
   }
    @PostConstruct
   public void init() {
	   usuario = new Usuario();
       SecurityContext context = SecurityContextHolder.getContext();
       if (context instanceof SecurityContext){
           Authentication authentication = context.getAuthentication();
           if (authentication instanceof Authentication){
               usuario.setUsername(((User)authentication.getPrincipal()).getUsername());
           }              
 }
      
      setSemanas( ListartodasSemanas());
     setSemana_selecionada(semanas.get(1));
     semanas_resumo_aux=  new SemanaController().getListarSemanas(semana_selecionada);
	   resumos_resumo_aux=  new ResumoController().getListarResumos(semanas_resumo_aux);
	   semanas_resumo = new ListDataModel<Semana>(semanas_resumo_aux);
	   resumos_resumo = new ListDataModel<Resumo>( resumos_resumo_aux);
       
       
   }

   
   public Usuario getUsuario() {
       return usuario;
   }

   public void setUsuario(Usuario usuario) {
       this.usuario = usuario;
   }

public List<String> getSemanas() {
	return semanas;
}

public void setSemanas(List<String> semanas) {
	this.semanas = semanas;
}

public String getSemana_selecionada() {
	return semana_selecionada;
}

public void setSemana_selecionada(String semana_selecionada) {
	this.semana_selecionada = semana_selecionada;
}

public DataModel<Semana> getSemanas_resumo() {
	return semanas_resumo;
}

public void setSemanas_resumo(DataModel<Semana> semanas_resumo) {
	this.semanas_resumo = semanas_resumo;
}

public DataModel<Resumo> getResumos_resumo() {
	return resumos_resumo;
}

public void setResumos_resumo(DataModel<Resumo> resumos_resumo) {
	this.resumos_resumo = resumos_resumo;
}





    
}