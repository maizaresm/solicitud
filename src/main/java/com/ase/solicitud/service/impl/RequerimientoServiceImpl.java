package com.ase.solicitud.service.impl;

import com.ase.solicitud.dto.RequerimientoDTO;
import com.ase.solicitud.exception.NotFoundException;
import com.ase.solicitud.mapper.RequerimientoMapper;
import com.ase.solicitud.persistence.entity.Requerimiento;
import com.ase.solicitud.persistence.repository.RequerimientoRepository;
import com.ase.solicitud.service.RequerimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class RequerimientoServiceImpl implements RequerimientoService {

    @Autowired
    private RequerimientoRepository requerimientoRepository;

    @Override
    public RequerimientoDTO save(RequerimientoDTO requerimientoDTO) {
        Requerimiento requerimiento = RequerimientoMapper.toEntity(requerimientoDTO);
        Requerimiento savedRequerimiento = requerimientoRepository.save(requerimiento);
        return RequerimientoMapper.toDTO(savedRequerimiento);
    }

    @Override
    public RequerimientoDTO getById(Long id) {

        return requerimientoRepository.findById(id)
                .map(RequerimientoMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Solicitud with ID " + id + " not found"));
    }

    @Override
    public Page<RequerimientoDTO> getAll(Pageable pageable) {
        Page<Requerimiento> requerimientos = requerimientoRepository.findAll(pageable);
        return requerimientos.map(RequerimientoMapper::toDTO);
    }

    @Override
    public void deleteById(Long id) {
        requerimientoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Solicitud with ID " + id + " not found"));
        requerimientoRepository.deleteById(id);
    }

    @Override
    public RequerimientoDTO update(Long id, RequerimientoDTO requerimientoDTO) {
        Requerimiento existingRequerimiento = requerimientoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Solicitud with ID " + id + " not found"));

        existingRequerimiento.setElemento(requerimientoDTO.getElemento());
        existingRequerimiento.setMarca(requerimientoDTO.getMarca());

        if (requerimientoDTO.getFechaEdicion() != null) {
            existingRequerimiento.setFechaEdicion(requerimientoDTO.getFechaEdicion());
        } else {
            existingRequerimiento.setFechaEdicion(new Date());
        }

        Requerimiento updatedRequerimiento = requerimientoRepository.save(existingRequerimiento);
        return RequerimientoMapper.toDTO(updatedRequerimiento);
    }
}