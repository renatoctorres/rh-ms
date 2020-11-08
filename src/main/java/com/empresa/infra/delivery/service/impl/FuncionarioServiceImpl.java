package com.empresa.infra.delivery.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.rh.FuncionarioDTO;
import com.empresa.infra.configuration.converter.FuncionarioConverter;
import com.empresa.infra.delivery.service.FuncionarioService;
import com.empresa.infra.repository.FuncionarioRepository;
import com.empresa.infra.repository.entity.Funcionario;

@Service
public class FuncionarioServiceImpl implements  FuncionarioService{
	
	@Autowired
	FuncionarioRepository repository;
	
	FuncionarioConverter converter = new FuncionarioConverter();
	
	
	public Optional<FuncionarioDTO> findById(Long id) {
		Optional<Funcionario> optFuncionario = this.repository.findById(id);
		if(optFuncionario.isPresent()) {
			return Optional.of(converter.convertFromEntity(optFuncionario.get()));
		}
		return Optional.empty();
	}
	
	public List<FuncionarioDTO> findAll() {
		List<Funcionario> listFuncionarios = this.repository.findAll();
		return converter.createFromEntities(listFuncionarios);
		
	}

	
	public Page<FuncionarioDTO> findByPage(Pageable pageable) {
		Page<Funcionario> pageFuncionario = this.repository.findAll(pageable);
		final Page<FuncionarioDTO> pageDTO = pageFuncionario.map(this::callConvert);
		return pageDTO;
	}
	
	public FuncionarioDTO save(FuncionarioDTO funcionarioDTO) {
		Funcionario func = this.repository.save(converter.convertFromDto(funcionarioDTO));
		return converter.convertFromEntity(func);
	}
	
	public void delete(FuncionarioDTO funcionarioDTO) {
		this.repository.delete(converter.convertFromDto(funcionarioDTO));
	}
	
	public FuncionarioDTO callConvert(Funcionario funcionario) {
		return converter.convertFromEntity(funcionario);
	}
	


}
