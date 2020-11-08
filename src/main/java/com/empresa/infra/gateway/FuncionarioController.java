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

import com.empresa.core.model.rh.FuncionarioDTO;
import com.empresa.infra.delivery.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> buscarTodos(){
		List<FuncionarioDTO> lista = this.service.findAll();
		return ResponseEntity.ok(lista);
			
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<FuncionarioDTO>> buscarPaginado(@RequestBody Pageable page){
		Page<FuncionarioDTO> pageFuncionario = this.service.findByPage(page);
		return ResponseEntity.ok(pageFuncionario);
			
	}
	
	@GetMapping("/codigo/{matricula}")
	public ResponseEntity<FuncionarioDTO> buscarPorMatricula(@PathVariable Long matricula){
		Optional<FuncionarioDTO> optFuncionario = this.service.findById(matricula);
		return ResponseEntity.ok(optFuncionario.get());
			
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDTO> salvar(@RequestBody FuncionarioDTO funcionario){
		FuncionarioDTO funcionarioDTO = this.service.save(funcionario);
		return ResponseEntity.ok(funcionarioDTO);
			
	}
	
	@PutMapping
	public ResponseEntity<FuncionarioDTO> atualizar(@RequestBody FuncionarioDTO funcionario){
		FuncionarioDTO funcionarioDTO = this.service.save(funcionario);
		return ResponseEntity.ok(funcionarioDTO);
			
	}
	
	


}
