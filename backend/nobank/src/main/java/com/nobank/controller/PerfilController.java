package com.nobank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @GetMapping("/hola")
    public ResponseEntity<String> holaMundo() {
        return ResponseEntity.ok("Hola Mundo2 ");
    }

}
