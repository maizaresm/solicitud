package com.ase.solicitud.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDTO {

    private Long id;

    private Date fechaDeCreacion;

    @NotNull(message = "El campo urgente es obligatorio")
    private Boolean urgente;

    private List<@Valid RequerimientoDTO> requerimientos;
}
