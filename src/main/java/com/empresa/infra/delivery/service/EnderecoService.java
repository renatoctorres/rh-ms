package com.empresa.infra.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.endereco.EnderecoDTO;
import com.empresa.core.model.rh.FuncionarioDTO;

@Service
public interface EnderecoService {
	
	public Optional<EnderecoDTO> findById(Long id);
	
	public List<EnderecoDTO> findAll();
	
	public Page<EnderecoDTO> findByPage(Pageable pageable);
	
	public List<EnderecoDTO> findAllByFuncionario(FuncionarioDTO funcionario);
	
	public List<EnderecoDTO> findAllByCodFuncionario(Long codFuncionario);
	
	public EnderecoDTO save(EnderecoDTO enderecoDTO);
	
	public void delete(EnderecoDTO enderecoDTO);

}
