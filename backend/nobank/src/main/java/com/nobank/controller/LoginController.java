package com.nobank.controller;

import com.nobank.domain.usuario.DatosAutentificadorUsuario;
import com.nobank.domain.usuario.Usuario;
import com.nobank.infra.security.DatosJWTtoken;
import com.nobank.infra.security.SecurityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.nobank.infra.security.TokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenServices tokenServices;
    @Autowired
    private SecurityService securityService;

    @PostMapping
    public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DatosAutentificadorUsuario datosAutentificacionUsuario, HttpServletRequest request) {
        try {

            String ipActual = securityService.obtenerIpCliente(request);
            Authentication authToken = new UsernamePasswordAuthenticationToken(
                    datosAutentificacionUsuario.login(), datosAutentificacionUsuario.password());
            Authentication usuarioAutenticado = authenticationManager.authenticate(authToken);
            securityService.resetIntentosFallidos(datosAutentificacionUsuario.login());
            var JWTtoken = tokenServices.generarToken((Usuario) usuarioAutenticado.getPrincipal());
            securityService.procesarAccesoDesdeNuevaUbicacion(datosAutentificacionUsuario.login(), ipActual);
            return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));

        } catch (BadCredentialsException e) {
            securityService.procesarIntentoFallido(datosAutentificacionUsuario.login());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }

}