package com.empresa.infra.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.telefone.TelefoneDTO;

@Service
public interface TelefoneService {
	
	public Optional<TelefoneDTO> findById(Long id);
	
	public List<TelefoneDTO> findAll();
	
	public Page<TelefoneDTO> findByPage(Pageable pageable);
	
	public TelefoneDTO save(TelefoneDTO telefone);

	public void delete(TelefoneDTO telefone);
	
	public List<TelefoneDTO> findByCodFuncionario(Long matricula);

}
