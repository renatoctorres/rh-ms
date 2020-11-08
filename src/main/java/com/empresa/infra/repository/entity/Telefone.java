package com.empresa.infra.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "TB_TELEFONE")
public class Telefone {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long codigo;
	
	String descricao;
	
	@ManyToOne
	@JoinColumn(name="cod_tipo_telefone")
	TipoTelefone tipoTelefone;


	String numero;
	
	String ddd;
	
	@ManyToOne
	@JoinColumn(name="cod_funcionario")
	Funcionario funcionario;
	
	
	public Telefone(Long codigo, String descricao, String ddd, String numero, TipoTelefone tipoTelefone,
			Funcionario funcionario) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipoTelefone = tipoTelefone;
		this.numero = numero;
		this.ddd = ddd;
		this.funcionario = funcionario;
	}


	public Telefone() {
		super();
	}
	
	

}
