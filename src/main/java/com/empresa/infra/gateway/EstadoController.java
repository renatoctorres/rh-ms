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

import com.empresa.core.model.endereco.EstadoDTO;
import com.empresa.infra.delivery.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	EstadoService service;
	
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> buscarTodos(){
		List<EstadoDTO> lista = this.service.findAll();
		return ResponseEntity.ok(lista);
			
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<EstadoDTO> buscarPorCodigo(@PathVariable Long codigo){
		Optional<EstadoDTO> optEstado = this.service.findById(codigo);
		return ResponseEntity.ok(optEstado.get());
			
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<EstadoDTO>> buscarPaginado(@RequestBody Pageable page){
		Page<EstadoDTO> pageEstadoDTO = this.service.findByPage(page);
		return ResponseEntity.ok(pageEstadoDTO);
			
	}
	
	@PostMapping
	public ResponseEntity<EstadoDTO> salvar(@RequestBody EstadoDTO estado){
		EstadoDTO estadoDTO = this.service.save(estado);
		return ResponseEntity.ok(estadoDTO);
			
	}
	
	@PutMapping
	public ResponseEntity<EstadoDTO> atualizar(@RequestBody EstadoDTO estado){
		EstadoDTO estadoDTO = this.service.save(estado);
		return ResponseEntity.ok(estadoDTO);
			
	}

}
