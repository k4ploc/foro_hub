package com.challenge.foro_hub.domain.topic;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String autor,
        String curso
) {

    public DatosListadoTopicos(Topic topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }
}
