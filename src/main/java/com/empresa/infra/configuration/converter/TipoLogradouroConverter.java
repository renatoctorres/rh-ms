package com.empresa.infra.configuration.converter;

import com.empresa.core.model.endereco.TipoLogradouroDTO;
import com.empresa.infra.repository.entity.TipoLogradouro;

public class TipoLogradouroConverter extends Converter<TipoLogradouroDTO, TipoLogradouro>{
	
	 public TipoLogradouroConverter() {
		  super(tipoLogradouroDTO -> new TipoLogradouro(tipoLogradouroDTO.getCodigo(),
				  					  tipoLogradouroDTO.getDescricao()
				  					  
				  ),
		  
		  		tipoLogradouro -> new TipoLogradouroDTO(tipoLogradouro.getCodigo(),
					  				  tipoLogradouro.getDescricao()));
		 }

}
