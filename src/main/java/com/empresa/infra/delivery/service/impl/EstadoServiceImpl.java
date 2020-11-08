package com.empresa.infra.delivery.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.endereco.EstadoDTO;
import com.empresa.infra.configuration.converter.EstadoConverter;
import com.empresa.infra.delivery.service.EstadoService;
import com.empresa.infra.repository.EstadoRepository;
import com.empresa.infra.repository.entity.Estado;

@Service
public class EstadoServiceImpl implements EstadoService{
	
	@Autowired
	EstadoRepository repository;
	
	EstadoConverter converter = new EstadoConverter();
	
	public Optional<EstadoDTO> findById(Long id) {
		Optional<Estado> optEstado = this.repository.findById(id);
		if(optEstado.isPresent()) {
			return Optional.of(converter.convertFromEntity(optEstado.get()));
		}
		return Optional.empty();
	}
	
	public List<EstadoDTO> findAll() {
		List<Estado> listEstados = this.repository.findAll();
		return converter.createFromEntities(listEstados);
	}
	
	public Page<EstadoDTO> findByPage(Pageable pageable) {
		Page<Estado> pageEstado = this.repository.findAll(pageable);
		final Page<EstadoDTO> pageDTO = pageEstado.map(this::callConvert);
		return pageDTO;
	}
	
	
	@Transactional
	public EstadoDTO save(EstadoDTO estadoDTO) {
		Estado estado = this.repository.save(this.converter.convertFromDto(estadoDTO));
		return this.converter.convertFromEntity(estado);
	}
	
	@Transactional
	public void delete(EstadoDTO estadoDTO) {
		this.repository.delete(this.converter.convertFromDto(estadoDTO));
	}
	
	public EstadoDTO callConvert(Estado estado) {
		return converter.convertFromEntity(estado);
	}


}
