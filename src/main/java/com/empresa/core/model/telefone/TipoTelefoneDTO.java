package com.empresa.core.model.telefone;

import com.empresa.core.model.EntidadeDTO;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class TipoTelefoneDTO extends EntidadeDTO{public TipoTelefoneDTO(Long codigo, String descricao) {
		super(codigo, descricao);
		// TODO Auto-generated constructor stub
	}


}
