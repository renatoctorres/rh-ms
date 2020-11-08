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

import com.empresa.core.model.telefone.TelefoneDTO;
import com.empresa.infra.delivery.service.TelefoneService;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {
	
	@Autowired
	TelefoneService service;
	
	
	@GetMapping
	public ResponseEntity<List<TelefoneDTO>> buscarTodos(){
		List<TelefoneDTO> lista = this.service.findAll();
		return ResponseEntity.ok(lista);
			
	}
	
	@GetMapping("/funcionario/{matricula}")
	public ResponseEntity<List<TelefoneDTO>> buscarPorFuncionario(@PathVariable Long matricula){
		List<TelefoneDTO> listTelefone = this.service.findByCodFuncionario(matricula);
		return ResponseEntity.ok(listTelefone);
			
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<TelefoneDTO> buscarPorCodigo(@PathVariable Long codigo){
		Optional<TelefoneDTO> optTelefoneDTO = this.service.findById(codigo);
		return ResponseEntity.ok(optTelefoneDTO.get());
			
	}  
	
	@GetMapping("/page")
	public ResponseEntity<Page<TelefoneDTO>> buscarPaginado(@RequestBody Pageable page){
		Page<TelefoneDTO> pageTelefoneDTO = this.service.findByPage(page);
		return ResponseEntity.ok(pageTelefoneDTO);
			
	}
	
	@PostMapping
	public ResponseEntity<TelefoneDTO> salvar(@RequestBody TelefoneDTO telefone){
		TelefoneDTO telefoneDTO = this.service.save(telefone);
		return ResponseEntity.ok(telefoneDTO);
			
	}
	
	@PutMapping
	public ResponseEntity<TelefoneDTO> atualizar(@RequestBody TelefoneDTO telefone){
		TelefoneDTO telefoneDTO = this.service.save(telefone);
		return ResponseEntity.ok(telefoneDTO);
			
	}

}
