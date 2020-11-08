package com.empresa.infra.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.rh.FuncionarioDTO;

@Service
public interface FuncionarioService {
	
	public Optional<FuncionarioDTO> findById(Long id);
	
	public List<FuncionarioDTO> findAll();
	
	public Page<FuncionarioDTO> findByPage(Pageable pageable);
	
	public FuncionarioDTO save(FuncionarioDTO funcionario);
	
	public void delete(FuncionarioDTO funcionario);

}
