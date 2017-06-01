package Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@SuppressWarnings("unused")
@Entity
public class Resumo implements Serializable {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String devolucao ;
private String divida;
private String deposito;
private Date salvo;
@ManyToOne(optional = false)
@JoinColumn(name = "cpf", referencedColumnName = "cpf")
private Motorista motorista;
@OneToOne
private Semana detalhes;

public Motorista getMotorista() {
	return motorista;
}

public void setMotorista(Motorista motorista) {
	this.motorista = motorista;
}

public Resumo(String devolucao,
		String divida, String deposito, Date salvo) {

this.devolucao = devolucao;
this.divida = divida;
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

public Semana getDetalhes() {
	return detalhes;
}

public void setDetalhes(Semana detalhes) {
	this.detalhes = detalhes;
}



}





