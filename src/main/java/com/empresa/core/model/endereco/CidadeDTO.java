package com.empresa.core.model.endereco;

import com.empresa.core.model.EntidadeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CidadeDTO extends EntidadeDTO{
	
	EstadoDTO estado;
	
	public CidadeDTO(Long codigo, String descricao, EstadoDTO estado) {
		super(codigo, descricao);
		this.estado = estado;
	}

	public CidadeDTO(Long codigo, String descricao, Long codigoEstado, String descricaoEstado) {
		super(codigo, descricao);
		this.estado = new EstadoDTO(codigoEstado, descricaoEstado, null, null);
	}

	

}
