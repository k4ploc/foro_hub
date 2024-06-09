package com.challenge.foro_hub.domain.usuario;

import com.challenge.foro_hub.domain.perfil.Perfil;

import java.util.List;

public record DatosUsuarioRequest(
        String nombre,
        String correo,
        String contrasena,
        List<Perfil> perfiles
) {
}
