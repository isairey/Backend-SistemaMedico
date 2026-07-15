package com.example.sismedico.repository;

import com.example.sismedico.entity.Rol;
import com.example.sismedico.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByNombre(RolNombre nombre);

}