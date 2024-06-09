package com.challenge.foro_hub.domain.respuesta;

import com.challenge.foro_hub.domain.topic.Topic;
import com.challenge.foro_hub.domain.topic.TopicoRepository;
import com.challenge.foro_hub.domain.usuario.Usuario;
import com.challenge.foro_hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;


    public Respuesta crearRespuesta(DatosRespuestaRequest datos) {
        Usuario autor = usuarioRepository.findById(datos.idUsuario()).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Topic topico = topicoRepository.findById(datos.idTopico()).orElseThrow(() -> new IllegalArgumentException("Topico no encontrado"));

        Respuesta respuesta = new Respuesta(datos.mensaje(), LocalDateTime.now(), topico, autor, false);

        return respuestaRepository.save(respuesta);


    }
}
