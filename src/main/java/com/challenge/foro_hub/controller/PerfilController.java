package com.challenge.foro_hub.controller;

import com.challenge.foro_hub.domain.perfil.DatosPerfilRequest;
import com.challenge.foro_hub.domain.perfil.Perfil;
import com.challenge.foro_hub.domain.perfil.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<Perfil> getAll() {
        return perfilService.listarPerfiles();
    }

    @PostMapping
    public Perfil create(@RequestBody DatosPerfilRequest datos) {
        return perfilService.crearPerfil(new Perfil(datos));
    }
}
