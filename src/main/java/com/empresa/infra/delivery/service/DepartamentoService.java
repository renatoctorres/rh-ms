package com.empresa.infra.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.rh.DepartamentoDTO;

@Service
public interface DepartamentoService {

	public Optional<DepartamentoDTO> findById(Long id);
	
	public List<DepartamentoDTO> findAll();
	
	public Page<DepartamentoDTO> findByPage(Pageable pageable);
	
	public DepartamentoDTO save(DepartamentoDTO departamento);
	
	public void delete(DepartamentoDTO departamento);

}
