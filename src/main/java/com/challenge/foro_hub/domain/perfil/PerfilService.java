package com.challenge.foro_hub.domain.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    public List<Perfil> listarPerfiles() {
        return repository.findAll();
    }

    public Perfil crearPerfil(Perfil perfil) {
        return repository.save(perfil);
    }
}
