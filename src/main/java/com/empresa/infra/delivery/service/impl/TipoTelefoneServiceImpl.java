package com.empresa.infra.delivery.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.telefone.TipoTelefoneDTO;
import com.empresa.infra.configuration.converter.TipoTelefoneConverter;
import com.empresa.infra.delivery.service.TipoTelefoneService;
import com.empresa.infra.repository.TipoTelefoneRepository;
import com.empresa.infra.repository.entity.TipoTelefone;

@Service
public class TipoTelefoneServiceImpl implements TipoTelefoneService{
	
	@Autowired
	TipoTelefoneRepository repository;
	
	TipoTelefoneConverter converter = new TipoTelefoneConverter();
	
	public Optional<TipoTelefoneDTO> findById(Long id) {
		Optional<TipoTelefone> optTipoTelefone = this.repository.findById(id);
		if(optTipoTelefone.isPresent()) {
			return Optional.of(converter.convertFromEntity(optTipoTelefone.get()));
		}
		return Optional.empty();
	}
	
	public List<TipoTelefoneDTO> findAll() {
		List<TipoTelefone> listTipoTelefones = this.repository.findAll();
		return converter.createFromEntities(listTipoTelefones);
	}
	
	public Page<TipoTelefoneDTO> findByPage(Pageable pageable) {
		Page<TipoTelefone> pageTelefone = this.repository.findAll(pageable);
		final Page<TipoTelefoneDTO> pageDTO = pageTelefone.map(this::callConvert);
		return pageDTO;
	}
	
	@Transactional
	public TipoTelefoneDTO save(TipoTelefoneDTO tipoTelefoneDTO) {
		TipoTelefone tipoTelefone = this.repository.save(this.converter.convertFromDto(tipoTelefoneDTO));
		return this.converter.convertFromEntity(tipoTelefone);
	}
	
	@Transactional
	public void delete(TipoTelefoneDTO tipoTelefoneDTO) {
		this.repository.delete(this.converter.convertFromDto(tipoTelefoneDTO));
	}
	
	public TipoTelefoneDTO callConvert(TipoTelefone tipoTelefone) {
		return converter.convertFromEntity(tipoTelefone);
	}


}
