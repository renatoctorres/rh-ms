package com.empresa.infra.delivery.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.rh.DepartamentoDTO;
import com.empresa.infra.configuration.converter.DepartamentoConverter;
import com.empresa.infra.delivery.service.DepartamentoService;
import com.empresa.infra.repository.DepartamentoRepository;
import com.empresa.infra.repository.entity.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	DepartamentoRepository repository;
	
	DepartamentoConverter converter = new DepartamentoConverter();
	
	public Optional<DepartamentoDTO> findById(Long id) {
		Optional<Departamento> optDepartamento = this.repository.findById(id);
		if(optDepartamento.isPresent()) {
			return Optional.of(converter.convertFromEntity(optDepartamento.get()));
		}
		return Optional.empty();
	}
	
	public List<DepartamentoDTO> findAll() {
		List<Departamento> listDepartamento = this.repository.findAll();
		return converter.createFromEntities(listDepartamento);
	}
	
	public Page<DepartamentoDTO> findByPage(Pageable pageable) {
		Page<Departamento> pageTelefone = this.repository.findAll(pageable);
		final Page<DepartamentoDTO> pageDTO = pageTelefone.map(this::callConvert);
		return pageDTO;
	}
	
	@Transactional
	public DepartamentoDTO save(DepartamentoDTO departamentoDTO) {
		Departamento departamento = this.repository.save(this.converter.convertFromDto(departamentoDTO));
		return this.converter.convertFromEntity(departamento);
	}
	
	@Transactional
	public void delete(DepartamentoDTO departamentoDTO) {
		this.repository.delete(this.converter.convertFromDto(departamentoDTO));
	}
	
	public DepartamentoDTO callConvert(Departamento departamento) {
		return converter.convertFromEntity(departamento);
	}

}
