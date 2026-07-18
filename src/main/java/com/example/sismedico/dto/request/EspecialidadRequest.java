package com.example.sismedico.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspecialidadRequest {

    @NotBlank(message = "El nombre de la especialidad es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    @Size(max = 300, message = "La descripción no puede superar los 300 caracteres")
    private String descripcion;

    @Size(max = 255, message = "El icono no puede superar los 255 caracteres")
    private String icono;

    @Pattern(
            regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$",
            message = "El color debe estar en formato hexadecimal. Ejemplo: #3B82F6"
    )
    private String color;

    @Size(max = 100, message = "La ubicación no puede superar los 100 caracteres")
    private String ubicacion;

    @Min(value = 10, message = "La duración mínima es de 10 minutos")
    @Max(value = 180, message = "La duración máxima es de 180 minutos")
    private Integer duracionConsulta;

    @DecimalMin(value = "0.0", inclusive = true, message = "El costo no puede ser negativo")
    private Double costoConsulta;

    @Builder.Default
    private Boolean activo = true;

}