package com.ase.solicitud.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PastOrPresent
    @CreationTimestamp
    @Column( nullable = false, updatable = false)
    private Date fechaDeCreacion;

    @NotNull(message = "El campo urgente es obligatorio")
    private Boolean urgente;

    @NotNull(message = "Debe haber al menos un requerimiento")
    @ManyToMany
    @JoinTable(
            name = "solicitud_requerimiento",
            joinColumns = @JoinColumn(name = "solicitud_id"),
            inverseJoinColumns = @JoinColumn(name = "requerimiento_id")
    )
    private List<Requerimiento> requerimientos;
}