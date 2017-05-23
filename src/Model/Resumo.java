package Model;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@SuppressWarnings("unused")
@Entity
public class Resumo implements Serializable {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@ManyToOne
@JoinColumn(name = "cpf", referencedColumnName = "cpf")
private Motorista motorista;
private String devolucao ;
private String divida;
private String semana;
private String deposito;
private Date salvo;


public Resumo(long id,Motorista motorista,  String devolucao,
		String divida, String semana, String deposito, Date salvo) {
this.id = id;
this.motorista=motorista;
this.devolucao = devolucao;
this.divida = divida;
this.semana = semana;
this.deposito = deposito;
this.salvo=salvo;
}

public Resumo(){}

public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}



public String getDevolucao() {
	return devolucao;
}


public void setDevolucao(String devolucao) {
	this.devolucao = devolucao;
}


public String getDivida() {
	return divida;
}


public void setDivida(String divida) {
	this.divida = divida;
}


public String getSemana() {
	return semana;
}


public void setSemana(String semana) {
	this.semana = semana;
}


public String getDeposito() {
	return deposito;
}


public void setDeposito(String deposito) {
	this.deposito = deposito;
}


public Date getSalvo() {
	return salvo;
}


public void setSalvo(Date salvo) {
	this.salvo = salvo;
}


public Motorista getMotorista() {
	return motorista;
}

public void setMotorista(Motorista motorista) {
	this.motorista = motorista;
}

}





