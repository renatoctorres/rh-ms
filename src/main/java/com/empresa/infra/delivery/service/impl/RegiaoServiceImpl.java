package com.empresa.infra.delivery.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.endereco.RegiaoDTO;
import com.empresa.infra.configuration.converter.RegiaoConverter;
import com.empresa.infra.delivery.service.RegiaoService;
import com.empresa.infra.repository.RegiaoRepository;
import com.empresa.infra.repository.entity.Regiao;

@Service
public class RegiaoServiceImpl implements RegiaoService{
	
	@Autowired
	RegiaoRepository repository;
	
	RegiaoConverter converter;
	
	public Optional<RegiaoDTO> findById(Long id) {
		Optional<Regiao> optRegiao = this.repository.findById(id);
		if(optRegiao.isPresent()) {
			return Optional.of(converter.convertFromEntity(optRegiao.get()));
		}
		return Optional.empty();
	}
	
	public List<RegiaoDTO> findAll() {
		List<Regiao> listRegiaos = this.repository.findAll();
		return converter.createFromEntities(listRegiaos);
	}
	
	public Page<RegiaoDTO> findByPage(Pageable pageable) {
		Page<Regiao> pageTelefone = this.repository.findAll(pageable);
		final Page<RegiaoDTO> pageDTO = pageTelefone.map(this::callConvert);
		return pageDTO;
	}
	
	@Transactional
	public RegiaoDTO save(RegiaoDTO regiaoDTO) {
		Regiao regiao = this.repository.save(this.converter.convertFromDto(regiaoDTO));
		return this.converter.convertFromEntity(regiao);
	}
	
	@Transactional
	public void delete(RegiaoDTO regiaoDTO) {
		this.repository.delete(this.converter.convertFromDto(regiaoDTO));
	}
	
	public RegiaoDTO callConvert(Regiao regiao) {
		return converter.convertFromEntity(regiao);
	}


}
