package com.empresa.infra.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "TB_ESTADO")
public class Estado {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long codigo;
	
	String descricao;
	
	String uf;
	
	@ManyToOne
	@JoinColumn(name="cod_regiao")
	Regiao regiao;
	
	
	public Estado(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}


	public Estado() {
		super();
	}
	
	



}
