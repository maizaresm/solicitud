package com.ase.solicitud.service;

import com.ase.solicitud.dto.SolicitudDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SolicitudService {

    SolicitudDTO saveSolicitud(SolicitudDTO solicitudDTO);
    SolicitudDTO getSolicitudById(Long id);
    Page<SolicitudDTO> getAllSolicitudes(Boolean urgente, String elemento, Pageable pageable);
    void deleteSolicitud(Long id);
}
