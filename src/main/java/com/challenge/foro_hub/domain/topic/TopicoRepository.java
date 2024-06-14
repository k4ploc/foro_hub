package com.challenge.foro_hub.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findByStatusIsNot(Status status, Pageable pageable);

    Page<Topic> findByCursoNombreContainingIgnoreCaseAndStatusIsNot(String cursoNombre, Status status, Pageable pageable);

    @Query("SELECT t FROM Topico t WHERE YEAR(t.fechaCreacion) = :anio AND t.status !='ELIMINADO'")
    Page<Topic> findByFechaCreacionYear(@Param("anio") int anio, Pageable pageable);

    Boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Optional<Topic> findByIdAndStatusIsNot(Long id, Status status);


}
