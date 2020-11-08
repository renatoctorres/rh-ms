package com.empresa.core.model.endereco;

import com.empresa.core.model.EntidadeDTO;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class TipoEnderecoDTO extends EntidadeDTO{

	public TipoEnderecoDTO(Long codigo, String descricao) {
		super(codigo, descricao);

	}

}
