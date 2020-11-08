package com.empresa.infra.delivery.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.endereco.EnderecoDTO;
import com.empresa.core.model.rh.FuncionarioDTO;
import com.empresa.infra.configuration.converter.EnderecoConverter;
import com.empresa.infra.delivery.service.EnderecoService;
import com.empresa.infra.repository.EnderecoRepository;
import com.empresa.infra.repository.entity.Endereco;

@Service
public class EnderecoServiceImpl implements EnderecoService{
	
	@Autowired
	EnderecoRepository repository;
	
	EnderecoConverter converter = new EnderecoConverter();
	
	public Optional<EnderecoDTO> findById(Long id) {
		Optional<Endereco> optEndereco = this.repository.findById(id);
		if(optEndereco.isPresent()) {
			return Optional.of(converter.convertFromEntity(optEndereco.get()));
		}
		return Optional.empty();
	}
	
	public List<EnderecoDTO> findAll() {
		List<Endereco> listEndereco = this.repository.findAll();
		return converter.createFromEntities(listEndereco);
	}
	
	public Page<EnderecoDTO> findByPage(Pageable pageable) {
		Page<Endereco> pageEndereco = this.repository.findAll(pageable);
		final Page<EnderecoDTO> pageDTO = pageEndereco.map(this::callConvert);
		return pageDTO;
	}
	
	public List<EnderecoDTO> findAllByFuncionario(FuncionarioDTO funcionario) {
		List<Endereco> listEndereco = this.repository.findAllByFuncionario(funcionario.getMatricula());
		return this.converter.createFromEntities(listEndereco);
	
	}
	
	public List<EnderecoDTO> findAllByCodFuncionario(Long codFuncionario) {
		List<Endereco> listEndereco = this.repository.findAllByFuncionario(codFuncionario);
		return this.converter.createFromEntities(listEndereco);
	}
	
	@Transactional
	public EnderecoDTO save(EnderecoDTO enderecoDTO) {
		Endereco endereco = this.repository.save(this.converter.convertFromDto(enderecoDTO));
		return this.converter.convertFromEntity(endereco);
	}
	
	@Transactional
	public void delete(EnderecoDTO enderecoDTO) {
		this.repository.delete(this.converter.convertFromDto(enderecoDTO));
	}
	
	public EnderecoDTO callConvert(Endereco endereco) {
		return converter.convertFromEntity(endereco);
	}
	
}
