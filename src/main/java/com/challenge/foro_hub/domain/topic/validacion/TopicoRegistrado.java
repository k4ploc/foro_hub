package com.challenge.foro_hub.domain.topic.validacion;

import com.challenge.foro_hub.domain.topic.DatosTopicoRequest;
import com.challenge.foro_hub.domain.topic.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoRegistrado implements ValidadorTopico {

    @Autowired
    TopicoRepository repository;


    @Override
    public void validar(DatosTopicoRequest datos) {
        if (datos.titulo() == null) {
            return;
        }
        var tituloTopicExiste = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (tituloTopicExiste) {
            throw new ValidationException("No se puede permitir un topico duplicado en el sistema");
        }
    }
}
