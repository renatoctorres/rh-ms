package com.empresa.infra.configuration.converter;

import com.empresa.core.model.endereco.EstadoDTO;
import com.empresa.infra.repository.entity.Estado;

public class EstadoConverter extends Converter<EstadoDTO, Estado>{
	
	 public EstadoConverter() {
		  super(estadoDTO -> new Estado(estadoDTO.getCodigo(),
				  					  estadoDTO.getDescricao()
				  					  
				  ),
		  
		  		estado -> new EstadoDTO(estado.getCodigo(),
					  				  estado.getDescricao()));
		 }

}
