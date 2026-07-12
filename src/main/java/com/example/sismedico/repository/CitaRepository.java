package com.example.sismedico.repository;

import com.example.sismedico.entity.Cita;
import com.example.sismedico.entity.Medico;
import com.example.sismedico.entity.Paciente;
import com.example.sismedico.enums.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByPaciente(Paciente paciente);

    List<Cita> findByMedico(Medico medico);

    List<Cita> findByFecha(LocalDate fecha);

    List<Cita> findByEstado(EstadoCita estado);

}