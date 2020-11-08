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

import com.empresa.core.model.endereco.EnderecoDTO;
import com.empresa.infra.delivery.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService service;
	
	
	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> buscarTodos(){
		List<EnderecoDTO> lista = this.service.findAll();
		return ResponseEntity.ok(lista);
			
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<EnderecoDTO> buscarPorCodigo(@PathVariable Long codigo){
		Optional<EnderecoDTO> optEnderecoDTO = this.service.findById(codigo);
		return ResponseEntity.ok(optEnderecoDTO.get());
			
	}
	
	@GetMapping("/funcionario/{matricula}")
	public ResponseEntity<List<EnderecoDTO>> buscarPorEstado(@PathVariable Long matricula){
		List<EnderecoDTO> listEndereco = this.service.findAllByCodFuncionario(matricula);
		return ResponseEntity.ok(listEndereco);
			
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<EnderecoDTO>> buscarPaginado(@RequestBody Pageable page){
		Page<EnderecoDTO> pageEnderecoDTO = this.service.findByPage(page);
		return ResponseEntity.ok(pageEnderecoDTO);
			
	}
	
	@PostMapping
	public ResponseEntity<EnderecoDTO> salvar(@RequestBody EnderecoDTO enderecoDTO){
		EnderecoDTO endereco = this.service.save(enderecoDTO);
		return ResponseEntity.ok(endereco);
			
	}
	
	@PutMapping
	public ResponseEntity<EnderecoDTO> atualizar(@RequestBody EnderecoDTO endereco){
		EnderecoDTO enderecoDTO = this.service.save(endereco);
		return ResponseEntity.ok(enderecoDTO);
			
	}

}
