package com.nobank.controller;

import com.nobank.domain.perfil.Perfil;
import com.nobank.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/{numeroCuenta}")
    public Perfil obtenerPerfilPorNumeroCuenta(@PathVariable String numeroCuenta) {
        return cuentaService.buscarPerfilPorNumeroCuenta(numeroCuenta);
    }
}
