package com.example.sismedico.entity;

import com.example.sismedico.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "citas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false, length = 36)
    private String uuid;

    /**
     * Paciente
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    /**
     * Médico
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    /**
     * Especialidad
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    /**
     * Fecha de la consulta
     */
    @Column(nullable = false)
    private LocalDate fecha;

    /**
     * Hora de la consulta
     */
    @Column(nullable = false)
    private LocalTime hora;

    /**
     * Motivo de la consulta
     */
    @Column(nullable = false, length = 500)
    private String motivo;

    /**
     * Observaciones
     */
    @Column(length = 1000)
    private String observaciones;

    /**
     * Estado
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private EstadoCita estado = EstadoCita.PENDIENTE;

    /**
     * Diagnóstico
     */
    @OneToOne(
            mappedBy = "cita",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Diagnostico diagnostico;

    /**
     * Fecha de registro
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    /**
     * Última actualización
     */
    private LocalDateTime fechaActualizacion;

    @PrePersist
    public void prePersist() {

        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }

        if (estado == null) {
            estado = EstadoCita.PENDIENTE;
        }

        fechaRegistro = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();

    }

    @PreUpdate
    public void preUpdate() {

        fechaActualizacion = LocalDateTime.now();

    }

}