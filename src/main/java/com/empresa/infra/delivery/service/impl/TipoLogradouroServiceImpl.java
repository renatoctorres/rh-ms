package com.empresa.infra.delivery.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.endereco.TipoLogradouroDTO;
import com.empresa.infra.configuration.converter.TipoLogradouroConverter;
import com.empresa.infra.delivery.service.TipoLogradouroService;
import com.empresa.infra.repository.TipoLogradouroRepository;
import com.empresa.infra.repository.entity.TipoLogradouro;

@Service
public class TipoLogradouroServiceImpl implements TipoLogradouroService{
	
	@Autowired
	TipoLogradouroRepository repository;
	
TipoLogradouroConverter converter = new TipoLogradouroConverter();
	
	public Optional<TipoLogradouroDTO> findById(Long id) {
		Optional<TipoLogradouro> optTipoLogradouro = this.repository.findById(id);
		if(optTipoLogradouro.isPresent()) {
			return Optional.of(converter.convertFromEntity(optTipoLogradouro.get()));
		}
		return Optional.empty();
	}
	
	public List<TipoLogradouroDTO> findAll() {
		List<TipoLogradouro> listTipoLogradouros = this.repository.findAll();
		return converter.createFromEntities(listTipoLogradouros);
	}
	
	public Page<TipoLogradouroDTO> findByPage(Pageable pageable) {
		Page<TipoLogradouro> pageTelefone = this.repository.findAll(pageable);
		final Page<TipoLogradouroDTO> pageDTO = pageTelefone.map(this::callConvert);
		return pageDTO;
	}
	
	@Transactional
	public TipoLogradouroDTO save(TipoLogradouroDTO tipoLogradouroDTO) {
		TipoLogradouro tipoLogradouro = this.repository.save(this.converter.convertFromDto(tipoLogradouroDTO));
		return this.converter.convertFromEntity(tipoLogradouro);
	}
	
	@Transactional
	public void delete(TipoLogradouroDTO tipoLogradouroDTO) {
		this.repository.delete(this.converter.convertFromDto(tipoLogradouroDTO));
	}
	
	public TipoLogradouroDTO callConvert(TipoLogradouro tipoLogradouro) {
		return converter.convertFromEntity(tipoLogradouro);
	}


}
