package com.ase.solicitud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequerimientoDTO {

    private Long id;

    @NotBlank(message = "El campo elemento es obligatorio")
    private String elemento;

    @NotBlank(message = "El campo marca es obligatorio")
    private String marca;

    @PastOrPresent(message = "La fecha de edición debe ser en el pasado o presente")
    private Date fechaEdicion;
}
