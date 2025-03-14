package com.nobank.domain.rolTipo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nobank.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "rol_tipo")
@Table(name = "rol_tipo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RolTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "rolTipo")
    @JsonIgnore
    private List<Usuario> usuarios;

}
