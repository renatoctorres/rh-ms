package com.empresa.infra.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "TB_TIPO_ENDERECO")
public class TipoEndereco {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long codigo;
	
	String descricao;
	
	
	public TipoEndereco() {
		super();
	}

	public TipoEndereco(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

}
