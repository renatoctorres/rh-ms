package com.empresa.core.model.rh;

import com.empresa.core.model.EntidadeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CargoDTO extends EntidadeDTO{
	
	DepartamentoDTO departamento;
	
	public CargoDTO(Long codigo, String descricao, DepartamentoDTO departamento) {
		super(codigo, descricao);
		this.departamento = departamento;
	}






}
