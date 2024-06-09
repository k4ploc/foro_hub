package com.challenge.foro_hub.controller;

import com.challenge.foro_hub.domain.respuesta.DatosRespuestaRequest;
import com.challenge.foro_hub.domain.respuesta.Respuesta;
import com.challenge.foro_hub.domain.respuesta.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> obtenerRespuestas() {
        return null;
    }

    @PostMapping
    public Respuesta guardarRespuesta(@RequestBody DatosRespuestaRequest datos) {
        return respuestaService.crearRespuesta(datos);
    }
}
