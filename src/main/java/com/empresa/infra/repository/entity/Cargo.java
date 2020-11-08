package com.empresa.infra.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity(name = "TB_CARGO")
public class Cargo {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	Long codigo;
	
	String descricao;
	
	@OneToOne
	@JoinColumn(name="cod_departamento")
	Departamento departamento;
	
	
	public Cargo(Long codigo, String descricao, Departamento departamento) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.departamento = departamento;
	}


	public Cargo() {
		super();
	}
	
	



}
