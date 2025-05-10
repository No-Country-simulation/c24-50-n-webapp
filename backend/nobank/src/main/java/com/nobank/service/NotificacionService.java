package com.nobank.service;

import com.nobank.domain.notificacion.Notificacion;
import com.nobank.domain.notificacion.NotificacionDTO;
import com.nobank.domain.usuario.Usuario;
import com.nobank.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private NotificacionRepository notificacionRepository;

    public Notificacion crearNotificacion(Long id, String mensaje, String tipo) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        Notificacion notificacion = new Notificacion();
        notificacion.setUsuario(usuario);
        notificacion.setMensaje(mensaje);
        notificacion.setTipo(tipo);
        return notificacionRepository.save(notificacion);
    }

    public List<NotificacionDTO> obtenerNotificacionesPorUsuario(Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        List<Notificacion> notificaciones = notificacionRepository.findByUsuarioOrderByFechaDesc(usuario);
        return notificaciones.stream()
                .map(notificacion -> new NotificacionDTO(
                        notificacion.getId(),
                        notificacion.getFecha(),
                        notificacion.getMensaje(),
                        notificacion.getTipo(),
                        notificacion.getUsuario().getId()))
                .collect(Collectors.toList());

    }

    public List<Notificacion> obtenerTodasLasNotificaciones() {
        return notificacionRepository.findAll();
    }
}
