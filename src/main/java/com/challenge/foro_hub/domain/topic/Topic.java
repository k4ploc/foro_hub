package com.challenge.foro_hub.domain.topic;


import com.challenge.foro_hub.domain.curso.Curso;
import com.challenge.foro_hub.domain.respuesta.Respuesta;
import com.challenge.foro_hub.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    @JsonManagedReference
    private List<Respuesta> respuestas;


    public Topic(String titulo, String mensaje, LocalDateTime now, Status status, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = now;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }
}
