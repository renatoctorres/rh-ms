package com.empresa.infra.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.telefone.TipoTelefoneDTO;

@Service
public interface TipoTelefoneService {
	
	public Optional<TipoTelefoneDTO> findById(Long id);
	
	public List<TipoTelefoneDTO> findAll();
	
	public Page<TipoTelefoneDTO> findByPage(Pageable pageable);

	public TipoTelefoneDTO save(TipoTelefoneDTO tipoTipoTelefone);
	
	public void delete(TipoTelefoneDTO tipoTipoTelefone);

}
