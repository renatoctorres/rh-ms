package com.empresa.infra.configuration.converter;

import com.empresa.core.model.telefone.TipoTelefoneDTO;
import com.empresa.infra.repository.entity.TipoTelefone;

public class TipoTelefoneConverter extends Converter<TipoTelefoneDTO, TipoTelefone>{
	
	 public TipoTelefoneConverter() {
		  super(tipoTelefoneDTO -> new TipoTelefone(tipoTelefoneDTO.getCodigo(),
				  					  tipoTelefoneDTO.getDescricao()
				  					  
				  ),
		  
		  		tipoTelefone -> new TipoTelefoneDTO(tipoTelefone.getCodigo(),
					  				  tipoTelefone.getDescricao()));
		 }

}
