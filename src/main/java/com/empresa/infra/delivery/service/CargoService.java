package com.empresa.infra.delivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empresa.core.model.rh.CargoDTO;
import com.empresa.infra.repository.entity.Departamento;

@Service
public interface CargoService {
	
	public Optional<CargoDTO> findById(Long id);
	
	public List<CargoDTO> findAll();
	
	public Page<CargoDTO> findByPage(Pageable pageable);
	
	public List<CargoDTO> findByDepartamento(Departamento departamento);
	
	public List<CargoDTO> findByCodDepartamento(Long codDepartamento);
	
	public CargoDTO save(CargoDTO cargo);
	
	public void delete(CargoDTO cargo);

}
