package com.challenge.foro_hub.domain.topic;

public record DatosTopicoRequest(
        String titulo,
        String mensaje,
        Status status,
        Long idCurso,
        Long idUsuario
) {
}
