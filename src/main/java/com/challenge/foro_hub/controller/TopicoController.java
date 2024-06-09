package com.challenge.foro_hub.controller;

import com.challenge.foro_hub.domain.topic.DatosTopicoRequest;
import com.challenge.foro_hub.domain.topic.Topic;
import com.challenge.foro_hub.domain.topic.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topico")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @GetMapping
    public List<Topic> listarTopicos() {
        return service.listarTopicos();
    }

    @PostMapping
    public Topic crearTopico(@RequestBody DatosTopicoRequest datos) {
        return service.createTopico(datos);
    }

}
