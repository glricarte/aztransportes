package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Autorizacao implements Serializable {

	@Id
	@Column(name="nome")
	private String nome;
	public Autorizacao(String nome){
		this.nome=nome;
	}

	public Autorizacao() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
	
}
