package com.nobank.infra.security;

import com.nobank.domain.usuario.Usuario;
import com.nobank.repository.UsuarioRepository;
import com.nobank.service.NotificacionService;
import com.nobank.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Autowired
    private UsuarioService  usuarioService;

    @Autowired
    private NotificacionService notificacionService;

    public void procesarIntentoFallido(String dni) {

        Usuario usuario = usuarioService.buscarUsuarioPorDni(dni);

        if (usuario != null) {

            usuario.incrementarIntentosFallidos();
            usuarioService.guardarUsuario(usuario);

            if (usuario.getIntentosFallidos() >= 2) {
                String mensaje = String.format("Se ha detectado %d intentos fallidos de inicio de sesión", usuario.getIntentosFallidos());
                notificacionService.crearNotificacion(usuario.getId(), mensaje, "ALERTA DE SEGURIDAD");
            }

        } else {

            System.out.println("Usuario no encontrado");
        }
    }

    public void resetIntentosFallidos(String dni) {
        Usuario usuario = usuarioService.buscarUsuarioPorDni(dni);
        usuario.setIntentosFallidos(0);
        usuarioService.guardarUsuario(usuario);
    }

    public void procesarAccesoDesdeNuevaUbicacion(String dni, String ipActual) {

        Usuario usuario = usuarioService.buscarUsuarioPorDni(dni);

        if (usuario != null) {

            String ultimaIp = usuario.getIpUltimaConexion();

            if (ultimaIp != null && !ultimaIp.equals(ipActual)) {
                // Se detecta un acceso desde una nueva IP
                notificacionService.crearNotificacion(usuario.getId(),
                        "Se ha detectado un acceso desde una nueva ubicación (IP: " + ipActual + ")",
                        "Seguridad");
            }

            usuario.setIpUltimaConexion(ipActual);
            usuarioService.guardarUsuario(usuario);
        }
    }

    public String obtenerIpCliente(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
