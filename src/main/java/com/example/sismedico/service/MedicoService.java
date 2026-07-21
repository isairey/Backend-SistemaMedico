package com.example.sismedico.service;

import com.example.sismedico.dto.request.MedicoRequest;
import com.example.sismedico.entity.Especialidad;
import com.example.sismedico.entity.Medico;
import com.example.sismedico.entity.Usuario;
import com.example.sismedico.repository.EspecialidadRepository;
import com.example.sismedico.repository.MedicoRepository;
import com.example.sismedico.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final EspecialidadRepository especialidadRepository;

    /**
     * Registrar médico
     */
    public Medico registrarMedico(MedicoRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado."));

        Especialidad especialidad = especialidadRepository.findById(request.getEspecialidadId())
                .orElseThrow(() ->
                        new RuntimeException("Especialidad no encontrada."));

        boolean cedulaExiste = medicoRepository.findAll()
                .stream()
                .anyMatch(m -> m.getCedulaProfesional()
                        .equalsIgnoreCase(request.getCedulaProfesional()));

        if (cedulaExiste) {
            throw new RuntimeException("La cédula profesional ya está registrada.");
        }

        Medico medico = Medico.builder()
                .usuario(usuario)
                .especialidad(especialidad)
                .cedulaProfesional(request.getCedulaProfesional())
                .biografia(request.getBiografia())
                .experiencia(request.getExperiencia())
                .costoConsulta(request.getCostoConsulta())
                .consultorio(request.getConsultorio())
                .activo(request.getActivo())
                .build();

        return medicoRepository.save(medico);

    }

    /**
     * Listar médicos
     */
    @Transactional(readOnly = true)
    public List<Medico> listarMedicos() {

        return medicoRepository.findAll();

    }

    /**
     * Obtener médico por ID
     */
    @Transactional(readOnly = true)
    public Medico obtenerPorId(Long id) {

        return medicoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Médico no encontrado."));

    }


        /**
     * Actualizar médico
     */
    public Medico actualizarMedico(
            Long id,
            MedicoRequest request) {

        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Médico no encontrado."));

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado."));

        Especialidad especialidad = especialidadRepository.findById(request.getEspecialidadId())
                .orElseThrow(() ->
                        new RuntimeException("Especialidad no encontrada."));

        boolean cedulaDuplicada = medicoRepository.findAll()
                .stream()
                .anyMatch(m ->
                        !m.getId().equals(id)
                                && m.getCedulaProfesional()
                                .equalsIgnoreCase(request.getCedulaProfesional())
                );

        if (cedulaDuplicada) {
            throw new RuntimeException("La cédula profesional ya está registrada.");
        }

        medico.setUsuario(usuario);
        medico.setEspecialidad(especialidad);
        medico.setCedulaProfesional(request.getCedulaProfesional());
        medico.setBiografia(request.getBiografia());
        medico.setExperiencia(request.getExperiencia());
        medico.setCostoConsulta(request.getCostoConsulta());
        medico.setConsultorio(request.getConsultorio());
        medico.setActivo(request.getActivo());

        return medicoRepository.save(medico);

    }


    /**
     * Eliminar médico
     */
    public void eliminarMedico(Long id) {

        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Médico no encontrado."));

        medicoRepository.delete(medico);

    }


    /**
     * Activar médico
     */
    public Medico activarMedico(Long id) {

        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Médico no encontrado."));

        medico.setActivo(true);

        return medicoRepository.save(medico);

    }


    /**
     * Desactivar médico
     */
    public Medico desactivarMedico(Long id) {

        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Médico no encontrado."));

        medico.setActivo(false);

        return medicoRepository.save(medico);

    }


    /**
     * Listar médicos activos
     */
    @Transactional(readOnly = true)
    public List<Medico> listarActivos() {

        return medicoRepository.findByActivoTrue();

    }

        /**
     * Verificar si existe un médico
     */
    @Transactional(readOnly = true)
    public boolean existeMedico(Long id) {

        return medicoRepository.existsById(id);

    }


    /**
     * Contar médicos registrados
     */
    @Transactional(readOnly = true)
    public long contarMedicos() {

        return medicoRepository.count();

    }


    /**
     * Guardar médico
     */
    private Medico guardar(Medico medico) {

        return medicoRepository.save(medico);

    }

}