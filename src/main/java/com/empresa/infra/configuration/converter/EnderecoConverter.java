package com.empresa.infra.configuration.converter;

import com.empresa.core.model.endereco.CidadeDTO;
import com.empresa.core.model.endereco.EnderecoDTO;
import com.empresa.core.model.endereco.TipoEnderecoDTO;
import com.empresa.core.model.endereco.TipoLogradouroDTO;
import com.empresa.infra.repository.entity.Cidade;
import com.empresa.infra.repository.entity.Endereco;
import com.empresa.infra.repository.entity.TipoEndereco;
import com.empresa.infra.repository.entity.TipoLogradouro;

public class EnderecoConverter extends Converter<EnderecoDTO, Endereco>{

	
	 public EnderecoConverter() {
		 
		  super(enderecoDTO -> new Endereco(enderecoDTO.getCodigo(),
				  					        enderecoDTO.getDescricao(),
				  					        new TipoEnderecoConverter().convertFromDto(enderecoDTO.getTipoEndereco()),
				  					     	new TipoLogradouroConverter().convertFromDto(enderecoDTO.getTipoLogradouro()),
				  					        enderecoDTO.getLogradouro(),
				  					        new CidadeConverter().convertFromDto(enderecoDTO.getCidade()),
				  					        enderecoDTO.getCodFuncionario(),
				  					        enderecoDTO.getNumero(),
				  					        enderecoDTO.getCep()
				  					  
				  ),
		  
		  		endereco -> new EnderecoDTO(endereco.getCodigo(),
		  									endereco.getDescricao(),
		  									new TipoEnderecoConverter().convertFromEntity(endereco.getTipoEndereco()),
		  									new TipoLogradouroConverter().convertFromEntity(endereco.getTipoLogradouro()),
		  									endereco.getLogradouro(),
		  									new CidadeConverter().convertFromEntity(endereco.getCidade()),   
		  									endereco.getNumero(),
									        endereco.getCep(),
									        endereco.getFuncionario().getMatricula()));
		 }
	 


}
