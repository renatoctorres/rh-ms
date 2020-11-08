package com.empresa.infra.gateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.core.model.rh.CargoDTO;
import com.empresa.infra.delivery.service.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	CargoService service;
	
	
	@GetMapping
	public ResponseEntity<List<CargoDTO>> buscarTodos(){
		List<CargoDTO> lista = this.service.findAll();
		return ResponseEntity.ok(lista);
			
	}
	
	@GetMapping("/departamento/{codDepartamento}")
	public ResponseEntity<List<CargoDTO>> buscarPorEstado(@PathVariable Long codDepartamento){
		List<CargoDTO> listCargo = this.service.findByCodDepartamento(codDepartamento);
		return ResponseEntity.ok(listCargo);
			
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<CargoDTO>> buscarPaginado(@RequestBody Pageable page){
		Page<CargoDTO> pageCargoDTO = this.service.findByPage(page);
		return ResponseEntity.ok(pageCargoDTO);
			
	}
	
	@PostMapping
	public ResponseEntity<CargoDTO> salvar(@RequestBody CargoDTO cargo){
		CargoDTO cargoDTO = this.service.save(cargo);
		return ResponseEntity.ok(cargoDTO);
			
	}
	
	@PutMapping
	public ResponseEntity<CargoDTO> atualizar(@RequestBody CargoDTO cargo){
		CargoDTO cargoDTO = this.service.save(cargo);
		return ResponseEntity.ok(cargoDTO);
			
	}

}
