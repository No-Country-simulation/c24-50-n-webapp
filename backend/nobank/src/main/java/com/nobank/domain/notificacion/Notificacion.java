package com.nobank.domain.notificacion;

import com.nobank.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "notificacion")
@Table(name = "notificacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

}