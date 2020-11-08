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

import com.empresa.core.model.endereco.RegiaoDTO;
import com.empresa.infra.delivery.service.RegiaoService;

@RestController
@RequestMapping("/regiao")
public class RegiaoController {
	
	@Autowired
	RegiaoService service;
	
	
	@GetMapping
	public ResponseEntity<List<RegiaoDTO>> buscarTodos(){
		List<RegiaoDTO> lista = this.service.findAll();
		return ResponseEntity.ok(lista);
			
	}
	
	
	@GetMapping("/page")
	public ResponseEntity<Page<RegiaoDTO>> buscarPaginado(@RequestBody Pageable page){
		Page<RegiaoDTO> pageRegiaoDTO = this.service.findByPage(page);
		return ResponseEntity.ok(pageRegiaoDTO);
			
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<RegiaoDTO> buscarPorCodigo(@PathVariable Long codigo){
		Optional<RegiaoDTO> optRegiaoDTO = this.service.findById(codigo);
		return ResponseEntity.ok(optRegiaoDTO.get());
			
	}
	
	@PostMapping
	public ResponseEntity<RegiaoDTO> salvar(@RequestBody RegiaoDTO regiao){
		RegiaoDTO regiaoDTO = this.service.save(regiao);
		return ResponseEntity.ok(regiaoDTO);
			
	}
	
	@PutMapping
	public ResponseEntity<RegiaoDTO> atualizar(@RequestBody RegiaoDTO regiao){
		RegiaoDTO regiaoDTO = this.service.save(regiao);
		return ResponseEntity.ok(regiaoDTO);
			
	}

}
