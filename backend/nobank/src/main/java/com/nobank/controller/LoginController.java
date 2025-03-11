package com.nobank.controller;

import com.nobank.domain.usuario.DatosAutentificadorUsuario;
import com.nobank.domain.usuario.Usuario;
import com.nobank.infra.security.DatosJWTtoken;
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

    @PostMapping
    public ResponseEntity<?> autenticarUsuario(@RequestBody @Valid DatosAutentificadorUsuario datosAutentificacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutentificacionUsuario.login(), datosAutentificacionUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenServices.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));
    }

    @PostMapping("/testlogin")
    public ResponseEntity<?> testLogin(@RequestBody @Valid DatosAutentificadorUsuario datosAutentificacionUsuario) {
        // Crear el token de autenticación usando los datos proporcionados
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutentificacionUsuario.login(), datosAutentificacionUsuario.password()
        );

        try {
            var usuarioAutenticado = authenticationManager.authenticate(authToken);
            return ResponseEntity.ok("Login exitoso para el usuario: " + usuarioAutenticado.getName());

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }

    @PostMapping("/verificar")
    public ResponseEntity<?> verificarToken(@RequestBody String token) {
        try {
            String subject = tokenServices.getSubject(token);
            return ResponseEntity.ok("Token válido para: " + subject);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido");


        }
    }
}