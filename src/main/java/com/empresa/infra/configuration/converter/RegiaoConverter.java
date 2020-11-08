package com.empresa.infra.configuration.converter;

import com.empresa.core.model.endereco.RegiaoDTO;
import com.empresa.infra.repository.entity.Regiao;

public class RegiaoConverter extends Converter<RegiaoDTO, Regiao>{
	
	 public RegiaoConverter() {
		  super(regiaoDTO -> new Regiao(regiaoDTO.getCodigo(),
				  					  regiaoDTO.getDescricao()
				  					  
				  ),
		  
		  		regiao -> new RegiaoDTO(regiao.getCodigo(),
					  				  regiao.getDescricao()));
		 }

}
