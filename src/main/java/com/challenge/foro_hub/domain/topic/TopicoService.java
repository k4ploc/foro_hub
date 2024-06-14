package com.challenge.foro_hub.domain.topic;


import com.challenge.foro_hub.domain.curso.Curso;
import com.challenge.foro_hub.domain.curso.CursoRepository;
import com.challenge.foro_hub.domain.topic.validacion.ValidadorTopico;
import com.challenge.foro_hub.domain.usuario.Usuario;
import com.challenge.foro_hub.domain.usuario.UsuarioRepository;
import com.challenge.foro_hub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.challenge.foro_hub.domain.topic.Status.ELIMINADO;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    List<ValidadorTopico> validadores;

    public Topic createTopico(DatosTopicoRequest datos) {

        validadores.forEach(v -> v.validar(datos));

        Usuario autor = usuarioRepository.findById(datos.idUsuario()).orElseThrow(() -> new ValidacionDeIntegridad(String.format("El usuario con el id %s no fue encontrado", datos.idUsuario())));
        Curso curso = cursoRepository.findById(datos.idCurso()).orElseThrow(() -> new ValidacionDeIntegridad(String.format("El curso con el id %s no fue encontrado", datos.idCurso())));


        Topic topico = new Topic(datos.titulo(), datos.mensaje(), LocalDateTime.now(), datos.status(), autor, curso);

        return topicoRepository.save(topico);
    }

    public Page<DatosListadoTopicos> listarTopicos(Pageable paginacion) {
        return topicoRepository.findByStatusIsNot(ELIMINADO, paginacion).map(DatosListadoTopicos::new);
    }

    public Page<DatosListadoTopicos> listarTopicosPorNombreCurso(String nombreCurso, Pageable paginacion) {
        return topicoRepository.findByCursoNombreContainingIgnoreCaseAndStatusIsNot(nombreCurso, ELIMINADO, paginacion).map(DatosListadoTopicos::new);

    }

    public Page<DatosListadoTopicos> listarTopicosPorAnio(int anio, Pageable paginacion) {
        return topicoRepository.findByFechaCreacionYear(anio, paginacion).map(DatosListadoTopicos::new);
    }

    public Topic getTopicoDetalle(Long id) {

        return topicoRepository.findById(id).orElseThrow(() -> new ValidacionDeIntegridad(String.format("El topico con id %s no fue encontrado", id)));
    }

    public Topic actualizarTopico(Long id, DatosActualizarTopico datosActualizarTopico) {

        Usuario autor = usuarioRepository.findById(datosActualizarTopico.idUsuario()).orElseThrow(() -> new ValidacionDeIntegridad(String.format("El usuario con el id %s no fue encontrado", datosActualizarTopico.idUsuario())));
        Curso curso = cursoRepository.findById(datosActualizarTopico.idCurso()).orElseThrow(() -> new ValidacionDeIntegridad(String.format("El curso con el id %s no fue encontrado", datosActualizarTopico.idCurso())));


        var topico = topicoRepository.findByIdAndStatusIsNot(id, ELIMINADO).orElseThrow(() -> new ValidacionDeIntegridad(String.format("El topico con id %s no fue encontrado para actualizar", id)));

        topico.actualizar(datosActualizarTopico, autor, curso);
        return topico;
    }

    public void eliminarTopico(Long id) {
        Topic topico = topicoRepository.findByIdAndStatusIsNot(id, ELIMINADO).orElseThrow(() -> new ValidacionDeIntegridad(String.format("El topico con id %s no fue encontrado para actualizar", id)));

        topico.eliminarTopico();
    }
}
