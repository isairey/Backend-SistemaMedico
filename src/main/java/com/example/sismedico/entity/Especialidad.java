package com.example.sismedico.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "especialidades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(length = 300)
    private String descripcion;

    @Column(length = 255)
    private String icono;

    @Column(length = 50)
    private String color;

    @Column(length = 100)
    private String ubicacion;

    @Column(nullable = false)
    @Builder.Default
    private Integer duracionConsulta = 30;

    @Column(nullable = false)
    @Builder.Default
    private Double costoConsulta = 0.0;

    @Column(nullable = false)
    @Builder.Default
    private Boolean activo = true;

    @Builder.Default
    @OneToMany(
            mappedBy = "especialidad",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Medico> medicos = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {

        fechaRegistro = LocalDateTime.now();

        if (activo == null) {
            activo = true;
        }

        if (duracionConsulta == null) {
            duracionConsulta = 30;
        }

        if (costoConsulta == null) {
            costoConsulta = 0.0;
        }

    }

}