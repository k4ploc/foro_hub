package com.challenge.foro_hub.domain.topic;

import jakarta.validation.constraints.NotNull;

public record DatosTopicoRequest(
        @NotNull(message = "Titulo es requerido")
        String titulo,
        @NotNull(message = "Mensaje es requerido")
        String mensaje,
        @NotNull(message = "Status del topico es requerido")
        Status status,
        @NotNull(message = "El id del curso es requerido")
        Long idCurso,
        @NotNull(message = "El id del usuario es requerido")
        Long idUsuario
) {
}
