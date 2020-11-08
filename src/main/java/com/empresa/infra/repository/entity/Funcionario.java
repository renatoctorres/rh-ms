package com.empresa.infra.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "TB_FUNCIONARIO")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long matricula;
	
	String nome;
	
	String email;
	
	@ManyToOne
	@JoinColumn(name="cod_cargo")
	Cargo cargo;
	
	String foto;

	public Funcionario(Long matricula, String nome, String email, Cargo cargo, String foto) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
		this.foto = foto;
	}

	public Funcionario() {
		super();
	}
	
	

}
