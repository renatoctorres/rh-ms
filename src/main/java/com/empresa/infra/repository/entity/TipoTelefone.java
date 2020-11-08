package com.empresa.infra.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "TB_TIPO_TELEFONE")
public class TipoTelefone {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long codigo;
	
	String descricao;
	
	public TipoTelefone(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public TipoTelefone() {
		super();
	}

}
