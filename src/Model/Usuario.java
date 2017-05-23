package Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Usuario implements Serializable {

   @Id
   private String username;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="cpf",referencedColumnName = "cpf")
   private Motorista motorista;
   private String password;
   @Column(name = "enable", columnDefinition = "BOOLEAN")
   private boolean enable;
   @OneToMany
   private List<Autorizacao> autorizacoes;

   public Usuario() {
   }
 
   public Usuario(String username, Motorista motorista, String password, boolean enable) {
	   this.username=username;
	   this.motorista=motorista;
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

public List<Autorizacao> getAutorizacoes() {
	return autorizacoes;
}

public void setAutorizacoes(List<Autorizacao> autorizacoes) {
	this.autorizacoes = autorizacoes;
}

public Motorista getMotorista() {
	return motorista;
}

public void setMotorista(Motorista motorista) {
	this.motorista = motorista;
}

   

}

