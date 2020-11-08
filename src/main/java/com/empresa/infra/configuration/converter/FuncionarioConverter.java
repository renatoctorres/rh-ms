package com.empresa.infra.configuration.converter;

import com.empresa.core.model.rh.FuncionarioDTO;
import com.empresa.infra.repository.entity.Funcionario;

public class FuncionarioConverter extends Converter<FuncionarioDTO, Funcionario> {
	
	 public FuncionarioConverter() {
		  super(funcionarioDTO -> new Funcionario(funcionarioDTO.getMatricula(),
		  							funcionarioDTO.getNome(),
		  							funcionarioDTO.getEmail(),
		  							new CargoConverter().convertFromDto(funcionarioDTO.getCargo()),
		  							funcionarioDTO.getFoto()),
		  
		  		funcionario -> new FuncionarioDTO(funcionario.getMatricula(),
					  							funcionario.getNome(),
					  							funcionario.getEmail(),
					  							new CargoConverter().convertFromEntity(funcionario.getCargo()),
					   							funcionario.getFoto()));
		 }

}


//this.matricula = matricula;
//this.nome = nome;
//this.email = email;
//this.cargo = cargo;
//this.foto = foto;