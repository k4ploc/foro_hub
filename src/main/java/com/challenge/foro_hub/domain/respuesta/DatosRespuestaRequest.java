package com.challenge.foro_hub.domain.respuesta;

public record DatosRespuestaRequest(
        Long idTopico,
        Long idUsuario,
        String mensaje
) {
}
