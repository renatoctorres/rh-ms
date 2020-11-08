package com.empresa.core.model.endereco;

import lombok.Data;

@Data
public class EnderecoDTO{
	
	public EnderecoDTO(Long codigo, String descricao, TipoEnderecoDTO tipoEnderecoDTO,
			TipoLogradouroDTO tipoLogradouroDTO, String logradouro, CidadeDTO cidadeDTO, Long numero, String cep,
			Long matricula) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipoEndereco = tipoEnderecoDTO;
		this.tipoLogradouro = tipoLogradouroDTO;
		this.logradouro = logradouro;
		this.cidade = cidadeDTO;
		this.numero = numero;
		this.cep = cep;
			
	}

	Long codigo;
	
	String descricao;
	
	TipoEnderecoDTO tipoEndereco;
	
	TipoLogradouroDTO tipoLogradouro;
	
	String logradouro;
	
	CidadeDTO cidade;
	
	Long numero;
	
	String cep;
	
	Long codFuncionario;

	

}
