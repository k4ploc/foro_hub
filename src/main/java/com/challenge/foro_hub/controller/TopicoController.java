package com.challenge.foro_hub.controller;

import com.challenge.foro_hub.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topico")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @GetMapping
    public Page<DatosListadoTopicos> listarTopicos(@RequestParam(required = false) String nombreCurso,
                                                   @RequestParam(required = false) String anio,
                                                   @PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion) {
        if (nombreCurso != null && !nombreCurso.isEmpty()) {
            return service.listarTopicosPorNombreCurso(nombreCurso, paginacion);
        } else if (anio != null && !anio.isEmpty()) {
            int anioInt = Integer.parseInt(anio);
            return service.listarTopicosPorAnio(anioInt, paginacion);
        } else {
            return service.listarTopicos(paginacion);
        }
    }

    @PostMapping
    public Topic crearTopico(@RequestBody @Valid DatosTopicoRequest datos) {
        return service.createTopico(datos);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTopico(@PathVariable Long id) {
        var topico = service.getTopicoDetalle(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity modificarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        var topicoActualizado = service.actualizarTopico(id, datos);
        return ResponseEntity.ok(new DatosDetalleTopico(topicoActualizado));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable @Valid Long id) {
        //  var topicoActualizado =
        service.eliminarTopico(id);
        return ResponseEntity.ok(String.format("El topico con id %s se ha eliminado correctamente", id));
    }

}
