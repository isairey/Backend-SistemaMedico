package com.example.sismedico.dto.request;

import com.example.sismedico.enums.Genero;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 100, message = "El apellido no puede superar los 100 caracteres")
    private String apellido;

    @Email(message = "Correo electrónico inválido")
    @NotBlank(message = "El correo es obligatorio")
    @Size(max = 150)
    private String correo;

    @Size(min = 8, max = 100,
            message = "La contraseña debe tener entre 8 y 100 caracteres")
    private String password;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "El teléfono debe contener 10 dígitos"
    )
    private String telefono;

    @Size(max = 255)
    private String direccion;

    @Size(max = 255)
    private String foto;

    @NotNull(message = "El género es obligatorio")
    private Genero genero;

    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @NotNull(message = "El rol es obligatorio")
    private Long rolId;

    @Builder.Default
    private Boolean activo = true;

    @Builder.Default
    private Boolean emailVerificado = false;

    @Size(max = 255)
    private String tokenFirebase;

}
