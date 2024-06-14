package com.challenge.foro_hub.domain.topic;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String autor,
        String curso) {
    public DatosDetalleTopico(Topic topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(),
                topico.getAutor().getNombre(), topico.getCurso().getNombre());

    }
}
