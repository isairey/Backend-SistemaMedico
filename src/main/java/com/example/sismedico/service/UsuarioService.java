package com.example.sismedico.service;

import com.example.sismedico.dto.request.UsuarioRequest;
import com.example.sismedico.entity.Rol;
import com.example.sismedico.entity.Usuario;
import com.example.sismedico.repository.RolRepository;
import com.example.sismedico.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;


    /**
     * Registrar usuario
     */
    public Usuario registrarUsuario(UsuarioRequest request) {


        if (usuarioRepository.existsByCorreo(request.getCorreo())) {
            throw new RuntimeException(
                    "El correo ya está registrado."
            );
        }


        Rol rol = rolRepository.findById(request.getRolId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Rol no encontrado."
                        ));


        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .correo(request.getCorreo())
                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )
                .telefono(request.getTelefono())
                .direccion(request.getDireccion())
                .foto(request.getFoto())
                .genero(request.getGenero())
                .fechaNacimiento(request.getFechaNacimiento())
                .rol(rol)
                .activo(request.getActivo())
                .emailVerificado(request.getEmailVerificado())
                .tokenFirebase(request.getTokenFirebase())
                .build();


        return usuarioRepository.save(usuario);

    }


    /**
     * Listar usuarios
     */
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {

        return usuarioRepository.findAll();

    }


    /**
     * Obtener usuario por ID
     */
    @Transactional(readOnly = true)
    public Usuario obtenerPorId(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuario no encontrado."
                        ));

    }


        /**
     * Actualizar usuario
     */
    public Usuario actualizarUsuario(
            Long id,
            UsuarioRequest request) {


        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuario no encontrado."
                        ));



        if (!usuario.getCorreo()
                .equalsIgnoreCase(request.getCorreo())
                &&
                usuarioRepository.existsByCorreo(
                        request.getCorreo())) {

            throw new RuntimeException(
                    "El correo ya está registrado."
            );

        }



        Rol rol = rolRepository.findById(
                        request.getRolId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Rol no encontrado."
                        ));




        usuario.setNombre(
                request.getNombre()
        );

        usuario.setApellido(
                request.getApellido()
        );


        usuario.setCorreo(
                request.getCorreo()
        );


        if (request.getPassword() != null &&
                !request.getPassword().isBlank()) {

            usuario.setPassword(
                    passwordEncoder.encode(
                            request.getPassword()
                    )
            );

        }



        usuario.setTelefono(
                request.getTelefono()
        );


        usuario.setDireccion(
                request.getDireccion()
        );


        usuario.setFoto(
                request.getFoto()
        );


        usuario.setGenero(
                request.getGenero()
        );


        usuario.setFechaNacimiento(
                request.getFechaNacimiento()
        );


        usuario.setRol(
                rol
        );


        usuario.setActivo(
                request.getActivo()
        );


        usuario.setEmailVerificado(
                request.getEmailVerificado()
        );


        usuario.setTokenFirebase(
                request.getTokenFirebase()
        );



        return usuarioRepository.save(usuario);

    }



    /**
     * Activar usuario
     */
    public Usuario activarUsuario(Long id) {


        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuario no encontrado."
                        ));



        usuario.setActivo(true);


        return usuarioRepository.save(usuario);

    }




    /**
     * Desactivar usuario
     */
    public Usuario desactivarUsuario(Long id) {


        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuario no encontrado."
                        ));



        usuario.setActivo(false);


        return usuarioRepository.save(usuario);

    }




    /**
     * Cambiar rol de usuario
     */
    public Usuario cambiarRol(
            Long usuarioId,
            Long rolId) {


        Usuario usuario =
                usuarioRepository.findById(usuarioId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Usuario no encontrado."
                                ));



        Rol rol =
                rolRepository.findById(rolId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Rol no encontrado."
                                ));



        usuario.setRol(rol);



        return usuarioRepository.save(usuario);

    }

        /**
     * Buscar usuario por correo
     */
    @Transactional(readOnly = true)
    public Usuario buscarPorCorreo(String correo) {


        return usuarioRepository.findByCorreo(correo)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuario no encontrado."
                        ));

    }



    /**
     * Verificar si existe usuario
     */
    @Transactional(readOnly = true)
    public boolean existeUsuario(Long id) {


        return usuarioRepository.existsById(id);

    }



    /**
     * Verificar si existe correo
     */
    @Transactional(readOnly = true)
    public boolean existeCorreo(String correo) {


        return usuarioRepository.existsByCorreo(correo);

    }



    /**
     * Eliminar usuario
     */
    public void eliminarUsuario(Long id) {


        Usuario usuario =
                usuarioRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Usuario no encontrado."
                                ));



        usuarioRepository.delete(usuario);

    }



    /**
     * Contar usuarios registrados
     */
    @Transactional(readOnly = true)
    public long contarUsuarios() {


        return usuarioRepository.count();

    }



    /**
     * Guardar usuario
     */
    private Usuario guardar(Usuario usuario) {


        return usuarioRepository.save(usuario);

    }

}