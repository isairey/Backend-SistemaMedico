package com.example.sismedico.entity;

import com.example.sismedico.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    // Paciente que agenda la cita
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    // Médico que atenderá
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    // Fecha de la consulta
    @Column(nullable = false)
    private LocalDate fecha;

    // Hora de la consulta
    @Column(nullable = false)
    private LocalTime hora;

    // Motivo de la consulta
    @Column(length = 500)
    private String motivo;

    // Observaciones
    @Column(length = 1000)
    private String observaciones;

    // Estado de la cita
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private EstadoCita estado = EstadoCita.PENDIENTE;

    // Diagnóstico generado durante la cita
    @OneToOne(
            mappedBy = "cita",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Diagnostico diagnostico;

    // Fecha de registro
    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {

        fechaRegistro = LocalDateTime.now();

        if (estado == null) {
            estado = EstadoCita.PENDIENTE;
        }

    }

}