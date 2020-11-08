package com.empresa.infra.gateway;

import java.util.List;
import java.util.Optional;

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

import com.empresa.core.model.rh.DepartamentoDTO;
import com.empresa.infra.delivery.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService service;
	
	
	@GetMapping
	public ResponseEntity<List<DepartamentoDTO>> buscarTodos(){
		List<DepartamentoDTO> lista = this.service.findAll();
		return ResponseEntity.ok(lista);
			
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<DepartamentoDTO> buscarPorCodigo(@PathVariable Long codigo){
		Optional<DepartamentoDTO> optDepartamentoDTO = this.service.findById(codigo);
		return ResponseEntity.ok(optDepartamentoDTO.get());
			
	}
	

	@GetMapping("/page")
	public ResponseEntity<Page<DepartamentoDTO>> buscarPaginado(@RequestBody Pageable page){
		Page<DepartamentoDTO> pageDepartamentoDTO = this.service.findByPage(page);
		return ResponseEntity.ok(pageDepartamentoDTO);
			
	}
	
	@PostMapping
	public ResponseEntity<DepartamentoDTO> salvar(@RequestBody DepartamentoDTO departamento){
		DepartamentoDTO departamentoDTO = this.service.save(departamento);
		return ResponseEntity.ok(departamentoDTO);
			
	}
	
	@PutMapping
	public ResponseEntity<DepartamentoDTO> atualizar(@RequestBody DepartamentoDTO departamento){
		DepartamentoDTO departamentoDTO = this.service.save(departamento);
		return ResponseEntity.ok(departamentoDTO);
			
	}

}
