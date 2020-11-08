package com.empresa.core.model.endereco;

import com.empresa.core.model.EntidadeDTO;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class RegiaoDTO extends EntidadeDTO{public RegiaoDTO(Long codigo, String descricao) {
		super(codigo, descricao);
	}

}
