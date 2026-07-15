package com.example.sismedico.entity;

import com.example.sismedico.enums.RolNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 30)
    private RolNombre nombre;

    @Column(length = 255)
    private String descripcion;

    @Builder.Default
    @OneToMany(
            mappedBy = "rol",
            fetch = FetchType.LAZY
    )
    private List<Usuario> usuarios = new ArrayList<>();

}