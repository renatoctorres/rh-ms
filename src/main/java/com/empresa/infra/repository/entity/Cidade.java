package com.empresa.infra.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "TB_CIDADE")
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	Long codigo;
	
	String descricao;
	
	@ManyToOne
	@JoinColumn(name="cod_estado")
	Estado estado;
	
	
	public Cidade(Long codigoCidade, String descricaoCidade, Estado estado) {
		this.codigo = codigoCidade;
		this.descricao = descricaoCidade;
		this.estado = estado;
	}


	public Cidade() {
		super();
	}
	
	





}
