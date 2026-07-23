package com.example.sismedico.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiagnosticoResponse {

    private Long id;

    // Cita
    private Long citaId;

    // Información del paciente
    private Long pacienteId;
    private String nombrePaciente;

    // Información del médico
    private Long medicoId;
    private String nombreMedico;

    // Diagnóstico
    private String diagnostico;

    private String tratamiento;

    private String observaciones;

    // Signos vitales
    private Double temperatura;

    private Integer frecuenciaCardiaca;

    private Integer frecuenciaRespiratoria;

    private String presionArterial;

    private Double peso;

    private Double altura;

    // Indicaciones médicas
    private String recomendaciones;

    private LocalDate proximaConsulta;

    private Boolean altaMedica;

    // Relación con receta
    private Boolean tieneReceta;

    private Long recetaId;

    // Auditoría
    private LocalDateTime fechaRegistro;

}