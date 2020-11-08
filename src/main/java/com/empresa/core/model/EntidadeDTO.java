package com.empresa.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class EntidadeDTO {
	
	Long codigo;
	
	String descricao;

}
