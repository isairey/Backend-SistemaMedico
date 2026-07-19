package com.example.sismedico.dto.response;

import com.example.sismedico.enums.EstadoCita;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CitaResponse {

    private Long id;

    private String uuid;

    // Paciente
    private Long pacienteId;
    private String nombrePaciente;

    // Médico
    private Long medicoId;
    private String nombreMedico;

    // Especialidad
    private Long especialidadId;
    private String especialidad;

    // Fecha y hora
    private LocalDate fecha;
    private LocalTime hora;

    // Información de la cita
    private String motivoConsulta;
    private String observaciones;

    private EstadoCita estado;

    // Datos opcionales
    private Boolean tieneDiagnostico;
    private Boolean tieneReceta;

    // Auditoría
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaActualizacion;

}