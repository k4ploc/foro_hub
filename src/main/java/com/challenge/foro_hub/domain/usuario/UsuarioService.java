package com.challenge.foro_hub.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarUsurios() {
        return repository.findAll();
    }

    public Usuario crearUsuraio(Usuario usuario) {
        return repository.save(usuario);
    }
}
