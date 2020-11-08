package com.empresa.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empresa.infra.repository.entity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{
	
	@Query("SELECT c FROM TB_CARGO c WHERE c.departamento = :codDepartamento")
	List<Cargo> findAllByDepartamento(Long codDepartamento);

}
