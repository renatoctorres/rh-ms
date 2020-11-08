package com.empresa.core.model.endereco;

import com.empresa.core.model.EntidadeDTO;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class TipoLogradouroDTO extends EntidadeDTO{
	

	public TipoLogradouroDTO(Long codigo, String descricao) {
		super(codigo, descricao);
	}


}
