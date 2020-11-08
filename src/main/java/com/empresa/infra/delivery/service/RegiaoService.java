package com.empresa.infra.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.endereco.RegiaoDTO;

@Service
public interface RegiaoService {
	
	public Optional<RegiaoDTO> findById(Long id);
	
	public List<RegiaoDTO> findAll();
	
	public Page<RegiaoDTO> findByPage(Pageable pageable);

	public RegiaoDTO save(RegiaoDTO regiaoDTO);

	public void delete(RegiaoDTO regiaoDTO);

}
