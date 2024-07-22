package com.ase.solicitud.service;

import com.ase.solicitud.dto.RequerimientoDTO;
import com.ase.solicitud.persistence.entity.Requerimiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RequerimientoService {

    RequerimientoDTO save(RequerimientoDTO requerimientoDTO);
    RequerimientoDTO getById(Long id);
    Page<RequerimientoDTO> getAll(Pageable pageable);
    void deleteById(Long id);
    RequerimientoDTO update(Long id, RequerimientoDTO requerimientoDTO);

}
