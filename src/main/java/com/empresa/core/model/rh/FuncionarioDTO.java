package com.empresa.core.model.rh;

import java.util.List;

import com.empresa.core.model.endereco.EnderecoDTO;
import com.empresa.core.model.telefone.TelefoneDTO;

import lombok.Data;

@Data
public class FuncionarioDTO {
	
	public FuncionarioDTO(Long matricula, String nome, String email, CargoDTO cargo , String foto
			) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.cargo = cargo;
		this.foto = foto;
	}



	String nome;
	
	Long matricula;
	
	String email;
	
	CargoDTO cargo;
	
	String foto;
	
	List<TelefoneDTO> telefones;
	
	List<EnderecoDTO> enderecos;
	
	

}
