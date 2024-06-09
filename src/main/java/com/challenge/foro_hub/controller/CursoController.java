package com.challenge.foro_hub.controller;

import com.challenge.foro_hub.domain.curso.Curso;
import com.challenge.foro_hub.domain.curso.CursoService;
import com.challenge.foro_hub.domain.curso.DatosCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getCurso() {
        return cursoService.listarCursos();
    }

    @PostMapping
    public Curso createCurso(@RequestBody DatosCurso datos) {
        return cursoService.insertarCurso(new Curso(datos));
    }
}
