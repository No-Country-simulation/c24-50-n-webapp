package com.nobank.domain.perfil;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nobank.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "perfil")
@Entity(name = "perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;
}
