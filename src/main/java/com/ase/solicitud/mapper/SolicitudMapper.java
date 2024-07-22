package com.ase.solicitud.mapper;

import com.ase.solicitud.dto.RequerimientoDTO;
import com.ase.solicitud.dto.SolicitudDTO;
import com.ase.solicitud.persistence.entity.Requerimiento;
import com.ase.solicitud.persistence.entity.Solicitud;

import java.util.List;
import java.util.stream.Collectors;

public class SolicitudMapper {
    public static SolicitudDTO toDTO(Solicitud solicitud) {
        SolicitudDTO dto = new SolicitudDTO();
        dto.setId(solicitud.getId());
        dto.setFechaDeCreacion(solicitud.getFechaDeCreacion());
        dto.setUrgente(solicitud.getUrgente());
        List<RequerimientoDTO> requerimientosDTO = solicitud.getRequerimientos()
                .stream()
                .map(RequerimientoMapper::toDTO)
                .collect(Collectors.toList());
        dto.setRequerimientos(requerimientosDTO);
        return dto;
    }

    public static Solicitud toEntity(SolicitudDTO dto) {
        Solicitud solicitud = new Solicitud();
        solicitud.setId(dto.getId());
        solicitud.setFechaDeCreacion(dto.getFechaDeCreacion());
        solicitud.setUrgente(dto.getUrgente());
        List<Requerimiento> requerimientos = dto.getRequerimientos()
                .stream()
                .map(RequerimientoMapper::toEntity)
                .collect(Collectors.toList());
        solicitud.setRequerimientos(requerimientos);
        return solicitud;
    }
}
