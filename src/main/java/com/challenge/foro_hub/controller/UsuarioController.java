package com.challenge.foro_hub.controller;

import com.challenge.foro_hub.domain.usuario.DatosUsuarioRequest;
import com.challenge.foro_hub.domain.usuario.Usuario;
import com.challenge.foro_hub.domain.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listarUsurios();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody DatosUsuarioRequest datos) {
        return service.crearUsuraio(new Usuario(datos));
    }
}
