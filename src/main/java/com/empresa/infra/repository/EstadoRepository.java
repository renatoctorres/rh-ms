package com.empresa.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.empresa.infra.repository.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
