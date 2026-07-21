package com.example.sismedico.service;

import com.example.sismedico.dto.request.PacienteRequest;
import com.example.sismedico.entity.Paciente;
import com.example.sismedico.entity.Usuario;
import com.example.sismedico.repository.PacienteRepository;
import com.example.sismedico.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;

    /**
     * Registrar paciente
     */
    public Paciente registrarPaciente(PacienteRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado."));

        boolean curpExiste = pacienteRepository.findAll()
                .stream()
                .anyMatch(p ->
                        p.getCurp().equalsIgnoreCase(request.getCurp()));

        if (curpExiste) {
            throw new RuntimeException("El CURP ya está registrado.");
        }

        if (request.getNumeroSeguroSocial() != null &&
                !request.getNumeroSeguroSocial().isBlank()) {

            boolean nssExiste = pacienteRepository.findAll()
                    .stream()
                    .anyMatch(p ->
                            request.getNumeroSeguroSocial()
                                    .equalsIgnoreCase(
                                            p.getNumeroSeguroSocial()));

            if (nssExiste) {
                throw new RuntimeException(
                        "El número de seguro social ya está registrado.");
            }

        }

        Paciente paciente = Paciente.builder()
                .usuario(usuario)
                .curp(request.getCurp())
                .numeroSeguroSocial(request.getNumeroSeguroSocial())
                .fechaNacimiento(request.getFechaNacimiento())
                .tipoSangre(request.getTipoSangre())
                .altura(request.getAltura())
                .peso(request.getPeso())
                .alergias(request.getAlergias())
                .enfermedadesCronicas(request.getEnfermedadesCronicas())
                .medicamentosActuales(request.getMedicamentosActuales())
                .contactoEmergencia(request.getContactoEmergencia())
                .telefonoEmergencia(request.getTelefonoEmergencia())
                .activo(request.getActivo())
                .build();

        return pacienteRepository.save(paciente);

    }

    /**
     * Listar pacientes
     */
    @Transactional(readOnly = true)
    public List<Paciente> listarPacientes() {

        return pacienteRepository.findAll();

    }

    /**
     * Obtener paciente por ID
     */
    @Transactional(readOnly = true)
    public Paciente obtenerPorId(Long id) {

        return pacienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paciente no encontrado."));

    }

        /**
     * Actualizar paciente
     */
    public Paciente actualizarPaciente(
            Long id,
            PacienteRequest request) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paciente no encontrado."));

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado."));

        boolean curpDuplicado = pacienteRepository.findAll()
                .stream()
                .anyMatch(p ->
                        !p.getId().equals(id)
                                && p.getCurp().equalsIgnoreCase(request.getCurp()));

        if (curpDuplicado) {
            throw new RuntimeException("El CURP ya está registrado.");
        }

        if (request.getNumeroSeguroSocial() != null &&
                !request.getNumeroSeguroSocial().isBlank()) {

            boolean nssDuplicado = pacienteRepository.findAll()
                    .stream()
                    .anyMatch(p ->
                            !p.getId().equals(id)
                                    && request.getNumeroSeguroSocial()
                                    .equalsIgnoreCase(p.getNumeroSeguroSocial()));

            if (nssDuplicado) {
                throw new RuntimeException(
                        "El número de seguro social ya está registrado.");
            }
        }

        paciente.setUsuario(usuario);
        paciente.setCurp(request.getCurp());
        paciente.setNumeroSeguroSocial(request.getNumeroSeguroSocial());
        paciente.setFechaNacimiento(request.getFechaNacimiento());
        paciente.setTipoSangre(request.getTipoSangre());
        paciente.setAltura(request.getAltura());
        paciente.setPeso(request.getPeso());
        paciente.setAlergias(request.getAlergias());
        paciente.setEnfermedadesCronicas(request.getEnfermedadesCronicas());
        paciente.setMedicamentosActuales(request.getMedicamentosActuales());
        paciente.setContactoEmergencia(request.getContactoEmergencia());
        paciente.setTelefonoEmergencia(request.getTelefonoEmergencia());
        paciente.setActivo(request.getActivo());

        return pacienteRepository.save(paciente);

    }

    /**
     * Eliminar paciente
     */
    public void eliminarPaciente(Long id) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paciente no encontrado."));

        pacienteRepository.delete(paciente);

    }

    /**
     * Activar paciente
     */
    public Paciente activarPaciente(Long id) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paciente no encontrado."));

        paciente.setActivo(true);

        return pacienteRepository.save(paciente);

    }

    /**
     * Desactivar paciente
     */
    public Paciente desactivarPaciente(Long id) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Paciente no encontrado."));

        paciente.setActivo(false);

        return pacienteRepository.save(paciente);

    }

        /**
     * Listar pacientes activos
     */
    @Transactional(readOnly = true)
    public List<Paciente> listarActivos() {

        return pacienteRepository.findAll()
                .stream()
                .filter(Paciente::getActivo)
                .toList();

    }

    /**
     * Verificar si existe un paciente
     */
    @Transactional(readOnly = true)
    public boolean existePaciente(Long id) {

        return pacienteRepository.existsById(id);

    }

    /**
     * Contar pacientes registrados
     */
    @Transactional(readOnly = true)
    public long contarPacientes() {

        return pacienteRepository.count();

    }

    /**
     * Guardar paciente
     */
    private Paciente guardar(Paciente paciente) {

        return pacienteRepository.save(paciente);

    }

}