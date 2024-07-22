package com.ase.solicitud.mapper;

import com.ase.solicitud.dto.RequerimientoDTO;
import com.ase.solicitud.persistence.entity.Requerimiento;

public class RequerimientoMapper {
    public static RequerimientoDTO toDTO(Requerimiento requerimiento) {
        RequerimientoDTO dto = new RequerimientoDTO();
        dto.setId(requerimiento.getId());
        dto.setElemento(requerimiento.getElemento());
        dto.setMarca(requerimiento.getMarca());
        dto.setFechaEdicion(requerimiento.getFechaEdicion());
        return dto;
    }

    public static Requerimiento toEntity(RequerimientoDTO dto) {
        Requerimiento requerimiento = new Requerimiento();
        requerimiento.setId(dto.getId());
        requerimiento.setElemento(dto.getElemento());
        requerimiento.setMarca(dto.getMarca());
        requerimiento.setFechaEdicion(dto.getFechaEdicion());
        return requerimiento;
    }
}
