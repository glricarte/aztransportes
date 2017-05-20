package Model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("unused")
@Entity
public class Motorista implements Serializable {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String nome;
private String tel;
private String cpf;
private String senha;
private boolean ativo;


public Motorista(){
	
}

public Motorista(long id, String nome, String tel,
		String cpf, String senha, boolean ativo) {
this.id = id;
this.nome = nome;
this.tel = tel;
this.cpf = cpf;
this.senha = senha;
this.ativo = ativo;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public boolean isAtivo() {
	return ativo;
}

public void setAtivo(boolean ativo) {
	this.ativo = ativo;
}


}

