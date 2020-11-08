package com.empresa.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empresa.infra.repository.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	@Query("SELECT c FROM TB_CIDADE c WHERE c.estado.codigo = :codigoEstado")
	List<Cidade> findAllByEstado(Long codigoEstado);

}
