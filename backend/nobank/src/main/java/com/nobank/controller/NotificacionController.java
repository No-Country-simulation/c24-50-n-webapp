package com.nobank.controller;

import com.nobank.domain.notificacion.Notificacion;
import com.nobank.domain.notificacion.NotificacionDTO;
import com.nobank.domain.usuario.Usuario;
import com.nobank.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    // Crear una nueva notificación para un usuario
    @PostMapping("/crear")
    public String crearNotificacion(@RequestParam Long usuarioId, @RequestParam String mensaje, @RequestParam String tipo) {
        notificacionService.crearNotificacion(usuarioId, mensaje, tipo);
        return "Notificación creada con éxito";
    }

    @GetMapping("/{usuarioId}")
    public List<NotificacionDTO> obtenerNotificacionesPorUsuario(@PathVariable Long usuarioId) {
        return notificacionService.obtenerNotificacionesPorUsuario(usuarioId);
    }
}
