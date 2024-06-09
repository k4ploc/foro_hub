package com.challenge.foro_hub.domain.topic;


import com.challenge.foro_hub.domain.curso.Curso;
import com.challenge.foro_hub.domain.curso.CursoRepository;
import com.challenge.foro_hub.domain.usuario.Usuario;
import com.challenge.foro_hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Topic createTopico(DatosTopicoRequest datos) {
        Usuario autor = usuarioRepository.findById(datos.idUsuario()).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Curso curso = cursoRepository.findById(datos.idCurso()).orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));


        Topic topico = new Topic(datos.titulo(), datos.mensaje(), LocalDateTime.now(), datos.status(), autor, curso);

        return topicoRepository.save(topico);
    }

    public List<Topic> listarTopicos() {
        return topicoRepository.findAll();
    }
}
