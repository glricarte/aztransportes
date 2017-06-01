package Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("unused")
@Entity
public class Semana implements Serializable {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@ManyToOne(optional = false)
@JoinColumn(name = "cpf", referencedColumnName = "cpf")
private Motorista motorista;
private String producao ;
private String aluguel;
private String desconto;
private String batida;
private String multa;
private String adiantamento;
private String semana;
private Date salvo;


public Semana( String producao,
		String aluguel, String desconto,String batida,
		String multa,String adiantamento, String semana, Date salvo) {
	

this.producao = producao;
this.aluguel = aluguel;
this.desconto = desconto;
this.batida = batida;
this.multa = multa;
this.adiantamento = adiantamento;
this.semana = semana;
this.salvo=salvo;
}

public Semana(){}

public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}



public String getProducao() {
	return producao;
}


public void setProducao(String producao) {
	this.producao = producao;
}


public String getAluguel() {
	return aluguel;
}


public void setAluguel(String aluguel) {
	this.aluguel = aluguel;
}


public String getSemana() {
	return semana;
}


public void setSemana(String semana) {
	this.semana = semana;
}


public String getDesconto() {
	return desconto;
}


public void setDesconto(String desconto) {
	this.desconto = desconto;
}


public Date getSalvo() {
	return salvo;
}


public void setSalvo(Date salvo) {
	this.salvo = salvo;
}

public String getBatida() {
	return batida;
}

public void setBatida(String batida) {
	this.batida = batida;
}

public String getMulta() {
	return multa;
}

public void setMulta(String multa) {
	this.multa = multa;
}

public String getAdiantamento() {
	return adiantamento;
}

public void setAdiantamento(String adiantamento) {
	this.adiantamento = adiantamento;
}


public Motorista getMotorista() {
	return motorista;
}

public void setMotorista(Motorista motorista) {
	this.motorista = motorista;
}

}





