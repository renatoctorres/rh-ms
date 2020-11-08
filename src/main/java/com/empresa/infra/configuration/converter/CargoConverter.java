package com.empresa.infra.configuration.converter;

import com.empresa.core.model.rh.CargoDTO;
import com.empresa.infra.repository.entity.Cargo;

public class CargoConverter extends Converter<CargoDTO, Cargo>{

	 public CargoConverter() {
		  super(cargoDTO -> new Cargo(cargoDTO.getCodigo(),
				  					  cargoDTO.getDescricao(),
				  					  new DepartamentoConverter().convertFromDto(cargoDTO.getDepartamento())
				  					  
				  ),
		  
		  		cargo -> new CargoDTO(cargo.getCodigo(),
					  				  cargo.getDescricao(),
					  				  new DepartamentoConverter().convertFromEntity(cargo.getDepartamento())
					  						  
					  				 ));
		 }

}
