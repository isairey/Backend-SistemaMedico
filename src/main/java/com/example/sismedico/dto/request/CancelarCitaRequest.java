package com.example.sismedico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancelarCitaRequest {

    @NotBlank(message = "El motivo de cancelación es obligatorio")
    @Size(
            min = 5,
            max = 500,
            message = "El motivo debe tener entre 5 y 500 caracteres"
    )
    private String motivo;

}