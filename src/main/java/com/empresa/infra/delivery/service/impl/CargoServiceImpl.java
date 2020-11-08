package com.empresa.infra.delivery.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.rh.CargoDTO;
import com.empresa.core.model.rh.DepartamentoDTO;
import com.empresa.infra.configuration.converter.CargoConverter;
import com.empresa.infra.delivery.service.CargoService;
import com.empresa.infra.repository.CargoRepository;
import com.empresa.infra.repository.entity.Cargo;
import com.empresa.infra.repository.entity.Departamento;

@Service
public class CargoServiceImpl implements CargoService{
	
	@Autowired
	CargoRepository repository;
	
	CargoConverter converter = new CargoConverter();
	
	public Optional<CargoDTO> findById(Long id) {
		Optional<Cargo> optCargo = this.repository.findById(id);
		if(optCargo.isPresent()) {
			return Optional.of(converter.convertFromEntity(optCargo.get()));
		}
		return Optional.empty();
	}
	
	public List<CargoDTO> findAll() {
		List<Cargo> listCargos = this.repository.findAll();
		return converter.createFromEntities(listCargos);
	}
	
	public Page<CargoDTO> findByPage(Pageable pageable) {
		Page<Cargo> pageCargo = this.repository.findAll(pageable);
		final Page<CargoDTO> pageDTO = pageCargo.map(this::callConvert);
		return pageDTO;
	
	}
	
	public List<CargoDTO> findByDepartamento(DepartamentoDTO departamentoDTO) {
		List<Cargo> listCargos = this.repository.findAllByDepartamento(departamentoDTO.getCodigo());
		return converter.createFromEntities(listCargos);
	}
	
	public List<CargoDTO> findByCodDepartamento(Long codDepartamento) {
		List<Cargo> listCargos = this.repository.findAllByDepartamento(codDepartamento);
		return converter.createFromEntities(listCargos);
	}
	
	@Transactional
	public CargoDTO save(CargoDTO cargoDTO) {
		Cargo cargo = this.repository.save(this.converter.convertFromDto(cargoDTO));
		return this.converter.convertFromEntity(cargo);
	}
	
	@Transactional
	public void delete(CargoDTO cargoDTO) {
		this.repository.delete(this.converter.convertFromDto(cargoDTO));
	}
	
	public CargoDTO callConvert(Cargo cargo) {
		return converter.convertFromEntity(cargo);
	}

	@Override
	public List<CargoDTO> findByDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	

}
