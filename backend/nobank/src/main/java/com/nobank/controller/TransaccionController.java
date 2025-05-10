package com.nobank.controller;

import com.nobank.domain.transacción.DatosIngresarTranseferencia;
import com.nobank.domain.transacción.Transaccion;
import com.nobank.domain.transacción.TransaccionDTO;
import com.nobank.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService transacciónService;

    @PostMapping
    public ResponseEntity<?> generarTransacción(@RequestBody DatosIngresarTranseferencia datosIngresarTranseferencia) {
        Transaccion transacción = transacciónService.transferirMontoCuenta(
                datosIngresarTranseferencia.cuentaOrigen(),
                datosIngresarTranseferencia.cuentaDestino(),
                datosIngresarTranseferencia.monto());

        return ResponseEntity.ok(transacción);

    }

    @GetMapping("/movimientos/{cuentaId}")
    public List<TransaccionDTO> obtenerMovimientos(@PathVariable Long cuentaId) {
        return transacciónService.obtenerMovimientosDeCuenta(cuentaId);
    }

}
