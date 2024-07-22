package com.ase.solicitud.persistence.repository;

import com.ase.solicitud.persistence.entity.Requerimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequerimientoRepository extends JpaRepository<Requerimiento, Long> {
    Optional<Requerimiento> findByElementoAndMarca(String elemento, String marca);
}
