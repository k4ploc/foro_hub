package com.challenge.foro_hub.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topic, Long> {

    Boolean existsByTitulo(String titulo);

    Boolean existsByTituloAndMensaje(String titulo, String mensaje);


}
