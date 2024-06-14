package com.challenge.foro_hub.domain.topic;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        Long id,
        @NotNull(message = "El id del curso es requerido")
        Long idCurso,
        @NotNull(message = "El id del usuario es requerido")
        Long idUsuario,
        @NotNull(message = "Titulo es requerido")
        String titulo,
        @NotNull(message = "Status del topico es requerido")
        Status status,
        @NotNull(message = "Mensaje es requerido")
        String mensaje
) {
}
