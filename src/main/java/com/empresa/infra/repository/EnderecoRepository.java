package com.empresa.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empresa.infra.repository.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	@Query("SELECT e FROM TB_ENDERECO e WHERE e.funcionario = :matricula")
	List<Endereco> findAllByFuncionario(Long matricula);

}
