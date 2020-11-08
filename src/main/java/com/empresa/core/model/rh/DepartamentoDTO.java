package com.empresa.core.model.rh;

import com.empresa.core.model.EntidadeDTO;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class DepartamentoDTO extends EntidadeDTO{
	
	public DepartamentoDTO(Long codigo, String descricao) {
		super(codigo, descricao);
	}

}
