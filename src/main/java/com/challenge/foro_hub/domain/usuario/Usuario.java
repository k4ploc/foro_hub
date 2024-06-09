package com.challenge.foro_hub.domain.usuario;

import com.challenge.foro_hub.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correoElectronico;
    private String contrasena;

    @ManyToMany
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private List<Perfil> perfiles;

    public Usuario(DatosUsuarioRequest datos) {
        this.nombre = datos.nombre();
        this.correoElectronico = datos.correo();
        this.contrasena = datos.contrasena();
        this.perfiles = datos.perfiles();
    }
}
