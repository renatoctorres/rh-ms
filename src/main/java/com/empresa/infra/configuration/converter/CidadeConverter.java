package com.empresa.infra.configuration.converter;

import com.empresa.core.model.endereco.CidadeDTO;
import com.empresa.infra.repository.entity.Cidade;

public class CidadeConverter extends Converter<CidadeDTO, Cidade> {
	
	 public CidadeConverter() {
		  super(cidadeDTO -> new Cidade(cidadeDTO.getCodigo(),
				  					  cidadeDTO.getDescricao(),
				  					  new EstadoConverter().convertFromDto(cidadeDTO.getEstado())
				  					  
				  ),
		  
		  		cidade -> new CidadeDTO(cidade.getCodigo(),
					  				  cidade.getDescricao(),
					  				  new EstadoConverter().convertFromEntity(cidade.getEstado())
					  				  ));
		 }

}
