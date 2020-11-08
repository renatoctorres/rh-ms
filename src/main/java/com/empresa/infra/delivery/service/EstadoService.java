package com.empresa.infra.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.endereco.EstadoDTO;

@Service
public interface EstadoService {
	
	public Optional<EstadoDTO> findById(Long id);
	
	public List<EstadoDTO> findAll();
	
	public Page<EstadoDTO> findByPage(Pageable pageable);

	public EstadoDTO save(EstadoDTO estado);
	
	public void delete(EstadoDTO estado);

}
