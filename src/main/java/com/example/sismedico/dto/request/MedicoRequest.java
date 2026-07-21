package com.example.sismedico.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicoRequest {

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "La especialidad es obligatoria")
    private Long especialidadId;

    @NotBlank(message = "La cédula profesional es obligatoria")
    @Size(
            max = 20,
            message = "La cédula profesional no puede exceder los 20 caracteres"
    )
    private String cedulaProfesional;

    @Size(
            max = 1000,
            message = "La biografía no puede exceder los 1000 caracteres"
    )
    private String biografia;

    @NotNull(message = "La experiencia es obligatoria")
    @Min(
            value = 0,
            message = "La experiencia no puede ser negativa"
    )
    @Max(
            value = 60,
            message = "La experiencia no puede ser mayor a 60 años"
    )
    private Integer experiencia;

    @NotNull(message = "El costo de consulta es obligatorio")
    @DecimalMin(
            value = "0.0",
            inclusive = true,
            message = "El costo debe ser mayor o igual a 0"
    )
    private Double costoConsulta;

    @NotBlank(message = "El consultorio es obligatorio")
    @Size(
            max = 100,
            message = "El consultorio no puede exceder los 100 caracteres"
    )
    private String consultorio;

    @Builder.Default
    private Boolean activo = true;

}