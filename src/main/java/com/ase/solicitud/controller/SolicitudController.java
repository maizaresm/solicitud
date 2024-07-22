package com.ase.solicitud.controller;

import com.ase.solicitud.dto.SolicitudDTO;
import com.ase.solicitud.service.SolicitudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public Page<SolicitudDTO> getAllSolicitudes(
            @RequestParam(required = false) Boolean urgente,
            @RequestParam(required = false) String elemento,
            Pageable pageable) {
        return solicitudService.getAllSolicitudes(urgente, elemento, pageable);
    }

    @GetMapping("/{id}")
    public SolicitudDTO getSolicitudById(@PathVariable Long id) {
        return solicitudService.getSolicitudById(id);
    }

    @PostMapping
    public SolicitudDTO createSolicitud(@RequestBody @Valid SolicitudDTO solicitudDTO) {
        return solicitudService.saveSolicitud(solicitudDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSolicitud(@PathVariable Long id) {
        solicitudService.deleteSolicitud(id);
    }
}
