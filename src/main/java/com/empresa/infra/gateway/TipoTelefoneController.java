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

import com.empresa.core.model.telefone.TipoTelefoneDTO;
import com.empresa.infra.delivery.service.TipoTelefoneService;

@RestController
@RequestMapping("/tipo-telefone")
public class TipoTelefoneController {
	
	@Autowired
	TipoTelefoneService service;
	
	
	@GetMapping
	public ResponseEntity<List<TipoTelefoneDTO>> buscarTodos(){
		List<TipoTelefoneDTO> lista = this.service.findAll();
		return ResponseEntity.ok(lista);
			
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<TipoTelefoneDTO> buscarPorCodigo(@PathVariable Long codigo){
		Optional<TipoTelefoneDTO> optTipoTelefone = this.service.findById(codigo);
		return ResponseEntity.ok(optTipoTelefone.get());
			
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<TipoTelefoneDTO>> buscarPaginado(@RequestBody Pageable page){
		Page<TipoTelefoneDTO> pageTipoTelefoneDTO = this.service.findByPage(page);
		return ResponseEntity.ok(pageTipoTelefoneDTO);
			
	}
	
	@PostMapping
	public ResponseEntity<TipoTelefoneDTO> salvar(@RequestBody TipoTelefoneDTO estado){
		TipoTelefoneDTO estadoDTO = this.service.save(estado);
		return ResponseEntity.ok(estadoDTO);
			
	}
	
	
	
	@PutMapping
	public ResponseEntity<TipoTelefoneDTO> atualizar(@RequestBody TipoTelefoneDTO estado){
		TipoTelefoneDTO estadoDTO = this.service.save(estado);
		return ResponseEntity.ok(estadoDTO);
			
	}

}
