package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;


@Entity
public class Usuario implements Serializable {

   @Id
   private String username;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="CPF", referencedColumnName = "CPF")
   private Motorista motorista;
   private String password;
   @Column(name = "enable", columnDefinition = "BOOLEAN")
   private boolean enable;
   @ManyToMany(cascade = CascadeType.ALL)
   private Collection<Autorizacao> autorizacoes;

   public Usuario() {
   }
 
   public Usuario(String username,String password, boolean enable) {
	   this.username=username;
	   this.password=password;
	   this.enable=enable;
   }
   
   
   
public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public boolean isEnable() {
	return enable;
}

public void setEnable(boolean enable) {
	this.enable = enable;
}
public Motorista getMotorista() {
	return motorista;
}

public void addAutorizacao(Autorizacao aut) {
      if (autorizacoes==null) {
          autorizacoes = new ArrayList<Autorizacao>();
      }
      if (!autorizacoes.contains(aut)) {
          autorizacoes.add(aut);
      }
  }

public Collection<Autorizacao> getAutorizacoes() {
	return autorizacoes;
}

public void setMotorista(Motorista motorista) {
	this.motorista = motorista;
}  

}

