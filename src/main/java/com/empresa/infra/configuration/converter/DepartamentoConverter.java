package com.empresa.infra.configuration.converter;

import com.empresa.core.model.rh.DepartamentoDTO;
import com.empresa.infra.repository.entity.Departamento;

public class DepartamentoConverter  extends Converter<DepartamentoDTO, Departamento>{
	
	 public DepartamentoConverter() {
		  super(departamentoDTO -> new Departamento(departamentoDTO.getCodigo(),
				  					  departamentoDTO.getDescricao()
				  					  
				  ),
		  
		  		departamento -> new DepartamentoDTO(departamento.getCodigo(),
					  				  departamento.getDescricao()));
		 }

}
