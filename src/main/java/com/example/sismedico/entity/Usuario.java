package com.example.sismedico.entity;

import com.example.sismedico.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false, length = 36)
    private String uuid;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(nullable = false, length = 100)
    private String apellido;

    @Email(message = "Correo inválido")
    @NotBlank(message = "El correo es obligatorio")
    @Column(nullable = false, unique = true, length = 150)
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(nullable = false)
    private String password;

    @Column(length = 20)
    private String telefono;

    @Column(length = 255)
    private String direccion;

    @Column(length = 255)
    private String fotoPerfil;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

    private LocalDate fechaNacimiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @Column(nullable = false)
    @Builder.Default
    private Boolean activo = true;

    @Column(nullable = false)
    @Builder.Default
    private Boolean emailVerificado = false;

    @Column(length = 255)
    private String tokenFirebase;

    private LocalDateTime ultimoAcceso;

    // ==========================
    // Relaciones
    // ==========================

    @OneToOne(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Paciente paciente;

    @OneToOne(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Medico medico;

    @Builder.Default
    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Notificacion> notificaciones = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    private LocalDateTime ultimaActualizacion;

    @PrePersist
    public void prePersist() {

        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }

        fechaRegistro = LocalDateTime.now();
        ultimaActualizacion = LocalDateTime.now();

        if (activo == null) {
            activo = true;
        }

        if (emailVerificado == null) {
            emailVerificado = false;
        }

    }

    @PreUpdate
    public void preUpdate() {
        ultimaActualizacion = LocalDateTime.now();
    }

}