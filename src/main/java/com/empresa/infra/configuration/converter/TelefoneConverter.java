package com.empresa.infra.configuration.converter;

import com.empresa.core.model.telefone.TelefoneDTO;
import com.empresa.infra.repository.entity.Funcionario;
import com.empresa.infra.repository.entity.Telefone;

public class TelefoneConverter extends Converter<TelefoneDTO, Telefone>{
	
	
	
	 public TelefoneConverter() {
		  super(telefoneDTO -> new Telefone(telefoneDTO.getCodigo(),
				  					  telefoneDTO.getDescricao(),
				  					  telefoneDTO.getDdd(),
				  					  telefoneDTO.getNumero(),
				  					  new TipoTelefoneConverter().convertFromDto(telefoneDTO.getTipoTelefone()),
				  					  new Funcionario(telefoneDTO.getCodUsuario(), null, null, null, null)
				  					  
				  					  
				  					  
				  ),
		  
		  		telefone -> new TelefoneDTO(telefone.getCodigo(),
					  				  		telefone.getDescricao(),
					  				  		new TipoTelefoneConverter().convertFromEntity(telefone.getTipoTelefone()),
					  				  		telefone.getNumero(),
					  				  		telefone.getDdd(),
					  				  	    telefone.getFuncionario().getMatricula()));
		 }

}
