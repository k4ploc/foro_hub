package com.challenge.foro_hub.domain.respuesta;

import com.challenge.foro_hub.domain.topic.Topic;
import com.challenge.foro_hub.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean solucion;

    @ManyToOne
    @JoinColumn(name = "topico")
    @JsonBackReference
    private Topic topico;

    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario autor;

    public Respuesta(String mensaje, LocalDateTime now, Topic topico, Usuario autor, boolean solucion) {
        this.mensaje = mensaje;
        this.fechaCreacion = now;
        this.topico = topico;
        this.autor = autor;
        this.solucion = solucion;
    }
}
