package com.empresa.core.model.telefone;

import com.empresa.core.model.EntidadeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TelefoneDTO extends EntidadeDTO{
	
	Long codUsuario;
	
	TipoTelefoneDTO tipoTelefone;
	
	String numero;
	
	String ddd;
	
	public TelefoneDTO(Long codigo, String descricao, TipoTelefoneDTO tipoTelefone, 
			String numero, String ddd, Long codUsuario) {
		super(codigo, descricao);
		this.tipoTelefone = tipoTelefone;
		this.numero = numero;
		this.ddd = ddd;
		this.codUsuario = codUsuario;
	}
	
	
	

}
