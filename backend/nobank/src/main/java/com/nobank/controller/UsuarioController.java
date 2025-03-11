package com.nobank.controller;

import com.nobank.domain.usuario.DatosRegistroUsuario;
import com.nobank.domain.usuario.Usuario;
import com.nobank.domain.usuario.UsuarioDTO;
import com.nobank.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("")
    public ResponseEntity<?> registrarUsuarioCliente(@RequestBody DatosRegistroUsuario datosRegistroUsuario) {
        Usuario usuario = usuarioService.registrarUsuarioCliente(datosRegistroUsuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerInformacionUsuario(@PathVariable Long id){
        return usuarioService.obteberInformacionUsuario(id);
    }

}


