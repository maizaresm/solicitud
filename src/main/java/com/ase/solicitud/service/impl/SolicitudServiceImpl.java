package com.ase.solicitud.service.impl;

import com.ase.solicitud.dto.SolicitudDTO;
import com.ase.solicitud.exception.NotFoundException;
import com.ase.solicitud.mapper.SolicitudMapper;
import com.ase.solicitud.persistence.entity.Requerimiento;
import com.ase.solicitud.persistence.entity.Solicitud;
import com.ase.solicitud.persistence.repository.RequerimientoRepository;
import com.ase.solicitud.persistence.repository.SolicitudRepository;
import com.ase.solicitud.service.SolicitudService;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private RequerimientoRepository requerimientoRepository;

    @Override
    public SolicitudDTO saveSolicitud(SolicitudDTO solicitudDTO) {
        Solicitud solicitud = SolicitudMapper.toEntity(solicitudDTO);
        solicitud.getRequerimientos().forEach(requerimiento -> {
            Optional<Requerimiento> existingRequerimiento = requerimientoRepository.findByElementoAndMarca(requerimiento.getElemento(), requerimiento.getMarca());
            if (existingRequerimiento.isPresent()) {
                requerimiento.setId(existingRequerimiento.get().getId());
            } else {
                requerimientoRepository.save(requerimiento);
            }
        });
        Solicitud savedSolicitud = solicitudRepository.save(solicitud);
        return SolicitudMapper.toDTO(savedSolicitud);
    }

    @Override
    public SolicitudDTO getSolicitudById(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Solicitud with ID " + id + " not found"));
        return SolicitudMapper.toDTO(solicitud);
    }

    @Override
    public Page<SolicitudDTO> getAllSolicitudes(Boolean urgente, String elemento, Pageable pageable) {
        Page<Solicitud> solicitudes = solicitudRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (urgente != null) {
                predicates.add(criteriaBuilder.equal(root.get("urgente"), urgente));
            }

            if (elemento != null && !elemento.isEmpty()) {
                Join<Solicitud, Requerimiento> requerimientoJoin = root.join("requerimientos");
                predicates.add(criteriaBuilder.equal(requerimientoJoin.get("elemento"), elemento));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);

        return solicitudes.map(SolicitudMapper::toDTO);
    }

    @Override
    public void deleteSolicitud(Long id) {
        solicitudRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Solicitud with ID " + id + " not found"));
        solicitudRepository.deleteById(id);
    }
}
