package com.example.sismedico.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteResponse {

    /**
     * ID del paciente
     */
    private Long id;

    /**
     * Usuario
     */
    private Long usuarioId;

    private String uuid;

    private String nombre;

    private String apellido;

    private String nombreCompleto;

    private String correo;

    private String telefono;

    /**
     * Información personal
     */
    private String curp;

    private String numeroSeguroSocial;

    private LocalDate fechaNacimiento;

    private String tipoSangre;

    /**
     * Información médica
     */
    private Double peso;

    private Double altura;

    private String alergias;

    private String enfermedadesCronicas;

    private String medicamentosActuales;

    /**
     * Contacto de emergencia
     */
    private String contactoEmergencia;

    private String telefonoEmergencia;

    /**
     * Estadísticas
     */
    private Integer totalCitas;

    /**
     * Estado
     */
    private Boolean activo;

    /**
     * Auditoría
     */
    private LocalDateTime fechaRegistro;

}