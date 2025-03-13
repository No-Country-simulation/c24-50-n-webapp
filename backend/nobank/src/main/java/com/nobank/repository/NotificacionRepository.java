package com.nobank.repository;

import com.nobank.domain.notificacion.Notificacion;
import com.nobank.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    List<Notificacion> findByUsuario(Usuario usuario);
}
