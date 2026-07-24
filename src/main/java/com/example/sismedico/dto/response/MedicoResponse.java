package com.example.sismedico.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicoResponse {

    /**
     * ID del médico
     */
    private Long id;

    /**
     * Usuario
     */
    private Long usuarioId;

    private String nombre;

    private String apellido;

    private String nombreCompleto;

    private String correo;

    private String telefono;

    /**
     * Especialidad
     */
    private Long especialidadId;

    private String especialidad;

    /**
     * Información profesional
     */
    private String cedulaProfesional;

    private String biografia;

    private Integer experiencia;

    private Double costoConsulta;

    private String consultorio;

    /**
     * Estadísticas
     */
    private Integer totalHorarios;

    private Integer totalCitas;

    /**
     * Estado
     */
    private Boolean activo;

    /**
     * Fecha de registro
     */
    private LocalDateTime fechaRegistro;

}