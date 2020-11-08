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

import com.empresa.core.model.endereco.TipoLogradouroDTO;
import com.empresa.infra.delivery.service.TipoLogradouroService;

@RestController
@RequestMapping("/tipo-logradouro")
public class TipoLogradouroController {
	
	@Autowired
	TipoLogradouroService service;
	
	
	@GetMapping
	public ResponseEntity<List<TipoLogradouroDTO>> buscarTodos(){
		List<TipoLogradouroDTO> lista = this.service.findAll();
		return ResponseEntity.ok(lista);
			
	}
	
	
	@GetMapping("/page")
	public ResponseEntity<Page<TipoLogradouroDTO>> buscarPaginado(@RequestBody Pageable page){
		Page<TipoLogradouroDTO> pageTipoLogradouroDTO = this.service.findByPage(page);
		return ResponseEntity.ok(pageTipoLogradouroDTO);
			
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<TipoLogradouroDTO> buscarPorCodigo(@PathVariable Long codigo){
		Optional<TipoLogradouroDTO> optTipoLogradouroDTO = this.service.findById(codigo);
		return ResponseEntity.ok(optTipoLogradouroDTO.get());
			
	}
	
	@PostMapping
	public ResponseEntity<TipoLogradouroDTO> salvar(@RequestBody TipoLogradouroDTO tipoLogradouro){
		TipoLogradouroDTO tipoLogradouroDTO = this.service.save(tipoLogradouro);
		return ResponseEntity.ok(tipoLogradouroDTO);
			
	}
	
	@PutMapping
	public ResponseEntity<TipoLogradouroDTO> atualizar(@RequestBody TipoLogradouroDTO tipoLogradouro){
		TipoLogradouroDTO tipoLogradouroDTO = this.service.save(tipoLogradouro);
		return ResponseEntity.ok(tipoLogradouroDTO);
			
	}

}
