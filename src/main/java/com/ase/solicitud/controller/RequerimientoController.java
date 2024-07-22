package com.ase.solicitud.controller;

import com.ase.solicitud.dto.RequerimientoDTO;
import com.ase.solicitud.service.RequerimientoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/requerimiento")
public class RequerimientoController {

    @Autowired
    private RequerimientoService requerimientoService;

    @GetMapping
    public Page<RequerimientoDTO> getAll(Pageable pageable) {
        return requerimientoService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public RequerimientoDTO getById(@PathVariable Long id) {
        return  requerimientoService.getById(id);
    }

    @PostMapping
    public ResponseEntity<RequerimientoDTO> createRequerimiento(@RequestBody @Valid RequerimientoDTO requerimientoDTO) {
        RequerimientoDTO createdRequerimiento = requerimientoService.save(requerimientoDTO);
        return new ResponseEntity<>(createdRequerimiento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteRequerimiento(@PathVariable Long id) {

         requerimientoService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RequerimientoDTO updateRequerimiento(@PathVariable Long id, @RequestBody @Valid RequerimientoDTO requerimientoDTO) {
        return  requerimientoService.update(id, requerimientoDTO);
    }
}