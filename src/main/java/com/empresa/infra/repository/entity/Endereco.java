package com.empresa.infra.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "TB_ENDERECO")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long codigo;
	
	String descricao;
	
	@ManyToOne
	@JoinColumn(name="cod_tipo_end")
	TipoEndereco tipoEndereco;
	

	@ManyToOne
	@JoinColumn(name="cod_tipo_logradouro")
	TipoLogradouro tipoLogradouro;
	
	String logradouro;
	
	@ManyToOne
	@JoinColumn(name="cod_cidade")
	Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name="cod_funcionario")
	Funcionario funcionario;
	
	Long numero;
	
	String cep;
	
	public Endereco(Long codigo, String descricao, TipoEndereco tipoEndereco, TipoLogradouro tipoLogradouro,
			String logradouro, Cidade cidade, Long codFuncionario, Long numero, String cep) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipoEndereco = tipoEndereco;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.funcionario = new Funcionario(codFuncionario, null, null, null, null);
		this.cidade = cidade;
		this.numero = numero;
		this.cep = cep;
	}

	public Endereco() {
		super();
	}
	
	

}
