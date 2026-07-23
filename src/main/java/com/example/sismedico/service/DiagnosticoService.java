package com.example.sismedico.service;

import com.example.sismedico.dto.request.DiagnosticoRequest;
import com.example.sismedico.entity.Cita;
import com.example.sismedico.entity.Diagnostico;
import com.example.sismedico.repository.CitaRepository;
import com.example.sismedico.repository.DiagnosticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;
    private final CitaRepository citaRepository;

    /**
     * Registrar diagnóstico
     */
    public Diagnostico registrarDiagnostico(DiagnosticoRequest request) {

        Cita cita = citaRepository.findById(request.getCitaId())
                .orElseThrow(() ->
                        new RuntimeException("La cita no existe."));

        if (diagnosticoRepository.existsByCita(cita)) {
            throw new RuntimeException(
                    "La cita ya tiene un diagnóstico registrado.");
        }

        Diagnostico diagnostico = Diagnostico.builder()
                .cita(cita)
                .diagnostico(request.getDiagnostico())
                .tratamiento(request.getTratamiento())
                .observaciones(request.getObservaciones())
                .temperatura(request.getTemperatura())
                .frecuenciaCardiaca(request.getFrecuenciaCardiaca())
                .frecuenciaRespiratoria(request.getFrecuenciaRespiratoria())
                .presionArterial(request.getPresionArterial())
                .peso(request.getPeso())
                .altura(request.getAltura())
                .recomendaciones(request.getRecomendaciones())
                .proximaConsulta(request.getProximaConsulta())
                .altaMedica(request.getAltaMedica())
                .build();

        return diagnosticoRepository.save(diagnostico);

    }

    /**
     * Listar diagnósticos
     */
    @Transactional(readOnly = true)
    public List<Diagnostico> listarDiagnosticos() {

        return diagnosticoRepository.findAll();

    }

    /**
     * Obtener diagnóstico por ID
     */
    @Transactional(readOnly = true)
    public Diagnostico obtenerPorId(Long id) {

        return diagnosticoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Diagnóstico no encontrado."));

    }

        /**
     * Actualizar diagnóstico
     */
    public Diagnostico actualizarDiagnostico(
            Long id,
            DiagnosticoRequest request) {

        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Diagnóstico no encontrado."));

        Cita cita = citaRepository.findById(request.getCitaId())
                .orElseThrow(() ->
                        new RuntimeException("La cita no existe."));

        if (!diagnostico.getCita().getId().equals(cita.getId())
                && diagnosticoRepository.existsByCita(cita)) {

            throw new RuntimeException(
                    "La cita ya tiene un diagnóstico registrado.");
        }

        diagnostico.setCita(cita);
        diagnostico.setDiagnostico(request.getDiagnostico());
        diagnostico.setTratamiento(request.getTratamiento());
        diagnostico.setObservaciones(request.getObservaciones());
        diagnostico.setTemperatura(request.getTemperatura());
        diagnostico.setFrecuenciaCardiaca(request.getFrecuenciaCardiaca());
        diagnostico.setFrecuenciaRespiratoria(request.getFrecuenciaRespiratoria());
        diagnostico.setPresionArterial(request.getPresionArterial());
        diagnostico.setPeso(request.getPeso());
        diagnostico.setAltura(request.getAltura());
        diagnostico.setRecomendaciones(request.getRecomendaciones());
        diagnostico.setProximaConsulta(request.getProximaConsulta());
        diagnostico.setAltaMedica(request.getAltaMedica());

        return diagnosticoRepository.save(diagnostico);

    }

    /**
     * Eliminar diagnóstico
     */
    public void eliminarDiagnostico(Long id) {

        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Diagnóstico no encontrado."));

        diagnosticoRepository.delete(diagnostico);

    }

    /**
     * Buscar diagnóstico por cita
     */
    @Transactional(readOnly = true)
    public Diagnostico buscarPorCita(Long citaId) {

        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() ->
                        new RuntimeException("La cita no existe."));

        return diagnosticoRepository.findByCita(cita)
                .orElseThrow(() ->
                        new RuntimeException(
                                "La cita no tiene diagnóstico registrado."));

    }

        /**
     * Dar alta médica
     */
    public Diagnostico darAltaMedica(Long id) {

        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Diagnóstico no encontrado."));

        diagnostico.setAltaMedica(true);

        return diagnosticoRepository.save(diagnostico);

    }

    /**
     * Quitar alta médica
     */
    public Diagnostico quitarAltaMedica(Long id) {

        Diagnostico diagnostico = diagnosticoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Diagnóstico no encontrado."));

        diagnostico.setAltaMedica(false);

        return diagnosticoRepository.save(diagnostico);

    }

    /**
     * Verificar si existe un diagnóstico
     */
    @Transactional(readOnly = true)
    public boolean existeDiagnostico(Long id) {

        return diagnosticoRepository.existsById(id);

    }

    /**
     * Contar diagnósticos registrados
     */
    @Transactional(readOnly = true)
    public long contarDiagnosticos() {

        return diagnosticoRepository.count();

    }

    /**
     * Guardar diagnóstico
     */
    private Diagnostico guardar(Diagnostico diagnostico) {

        return diagnosticoRepository.save(diagnostico);

    }

}