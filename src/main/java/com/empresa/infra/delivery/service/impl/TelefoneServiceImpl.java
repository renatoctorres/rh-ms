package com.empresa.infra.delivery.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.telefone.TelefoneDTO;
import com.empresa.infra.configuration.converter.TelefoneConverter;
import com.empresa.infra.delivery.service.TelefoneService;
import com.empresa.infra.repository.TelefoneRepository;
import com.empresa.infra.repository.entity.Telefone;

@Service
public class TelefoneServiceImpl implements TelefoneService{
	
	@Autowired
	TelefoneRepository repository;
	
	TelefoneConverter converter = new TelefoneConverter();
	
	public Optional<TelefoneDTO> findById(Long id) {
		Optional<Telefone> optTelefone = this.repository.findById(id);
		if(optTelefone.isPresent()) {
			return Optional.of(converter.convertFromEntity(optTelefone.get()));
		}
		return Optional.empty();
	}
	
	public List<TelefoneDTO> findAll() {
		List<Telefone> listTelefones = this.repository.findAll();
		return converter.createFromEntities(listTelefones);
	}
	
	public Page<TelefoneDTO> findByPage(Pageable pageable) {
		Page<Telefone> pageTelefone = this.repository.findAll(pageable);
		final Page<TelefoneDTO> pageDTO = pageTelefone.map(this::callConvert);
		return pageDTO;
	}
	
	public List<TelefoneDTO> findByCodFuncionario(Long matricula) {
		List<Telefone> listTelefones = this.repository.findAllByFuncionario(matricula);
		return converter.createFromEntities(listTelefones);
	}
	
	@Transactional
	public TelefoneDTO save(TelefoneDTO telefoneDTO) {
		Telefone telefone = this.repository.save(this.converter.convertFromDto(telefoneDTO));
		return this.converter.convertFromEntity(telefone);
	}
	
	@Transactional
	public void delete(TelefoneDTO telefoneDTO) {
		this.repository.delete(this.converter.convertFromDto(telefoneDTO));
	}
	
	public TelefoneDTO callConvert(Telefone telefone) {
		return converter.convertFromEntity(telefone);
	}

}
