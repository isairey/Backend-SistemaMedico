package com.example.sismedico.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteRequest {

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El CURP es obligatorio")
    @Size(min = 18, max = 18, message = "El CURP debe tener 18 caracteres")
    private String curp;

    @Size(max = 20, message = "El número de seguro no puede superar los 20 caracteres")
    private String numeroSeguroSocial;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @Size(max = 5, message = "El tipo de sangre no puede superar los 5 caracteres")
    private String tipoSangre;

    @DecimalMin(value = "0.50", message = "La altura es inválida")
    @DecimalMax(value = "3.00", message = "La altura es inválida")
    private Double altura;

    @DecimalMin(value = "1.00", message = "El peso es inválido")
    @DecimalMax(value = "500.00", message = "El peso es inválido")
    private Double peso;

    @Size(max = 500, message = "Las alergias no pueden superar los 500 caracteres")
    private String alergias;

    @Size(max = 500, message = "Las enfermedades crónicas no pueden superar los 500 caracteres")
    private String enfermedadesCronicas;

    @Size(max = 500, message = "Los medicamentos no pueden superar los 500 caracteres")
    private String medicamentosActuales;

    @NotBlank(message = "El contacto de emergencia es obligatorio")
    @Size(max = 100)
    private String contactoEmergencia;

    @NotBlank(message = "El teléfono de emergencia es obligatorio")
    @Size(max = 20)
    private String telefonoEmergencia;

    @Builder.Default
    private Boolean activo = true;

}