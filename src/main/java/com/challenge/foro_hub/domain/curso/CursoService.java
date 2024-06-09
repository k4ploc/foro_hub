package com.challenge.foro_hub.domain.curso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> listarCursos() {
        return repository.findAll();
    }

    public Curso insertarCurso(Curso curso) {
        return repository.save(curso);
    }
}
