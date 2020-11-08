package com.empresa.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empresa.infra.repository.entity.Telefone;


@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
	
	@Query("SELECT t FROM TB_TELEFONE t WHERE t.funcionario = :matricula")
	List<Telefone> findAllByFuncionario(Long matricula);


}
