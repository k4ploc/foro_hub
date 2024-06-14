package com.challenge.foro_hub.domain.topic.validacion;

import com.challenge.foro_hub.domain.topic.DatosTopicoRequest;

public interface ValidadorTopico {
    public void validar(DatosTopicoRequest datos);
}
