package com.empresa.core.model.endereco;

import com.empresa.core.model.EntidadeDTO;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class EstadoDTO extends EntidadeDTO{
	
	public EstadoDTO(Long codigo, String descricao, char[] uf, RegiaoDTO regiao) {
		super(codigo, descricao);
		this.uf = uf;
		this.regiao = regiao;
	}

	public EstadoDTO(Long codigo, String descricao) {
		super(codigo, descricao);
	}

	char[] uf;
	
	RegiaoDTO regiao;
	
}
