package com.nobank.service;

import com.nobank.domain.cuenta.Cuenta;
import com.nobank.domain.transacción.Transaccion;
import com.nobank.domain.transacción.TransaccionDTO;
import com.nobank.repository.TransaccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private CuentaService cuentaService;

    @Transactional
    public Transaccion transferirMontoCuenta(String origen, String destino, BigDecimal monto){
        Cuenta cuentaOrigen = cuentaService.buscarCuentaPorNumeroCuenta(origen);
        Cuenta cuentaDestino = cuentaService.buscarCuentaPorNumeroCuenta(destino);

        if (cuentaOrigen.getBalance().compareTo(monto) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente en la cuenta de origen.");
        }

        cuentaOrigen.setBalance(cuentaOrigen.getBalance().subtract(monto));
        cuentaDestino.setBalance(cuentaDestino.getBalance().add(monto));

        cuentaService.guardarCuenta(cuentaOrigen);
        cuentaService.guardarCuenta(cuentaDestino);

        Transaccion transacción = new Transaccion(cuentaOrigen, cuentaDestino, monto);
        return transaccionRepository.save(transacción);

    }

    public List<TransaccionDTO> obtenerMovimientosDeCuenta(Long cuentaId) {
        List<Transaccion> transacciones = transaccionRepository.findByCuentaOrigenIdOrCuentaDestinoId(cuentaId, cuentaId)
                .orElseThrow(() -> new RuntimeException("No se encontraron transacciones"));

        return transacciones.stream().map(transaccion -> {
            boolean esIngreso = transaccion.getCuentaDestino().getId().equals(cuentaId);
            return new TransaccionDTO(
                    transaccion.getId(),
                    transaccion.getMonto(),
                    esIngreso ? "INGRESO" : "EGRESO",
                    transaccion.getCuentaOrigen().getId(),
                    transaccion.getCuentaDestino().getId(),
                    transaccion.getEstado(),
                    transaccion.getFecha()
            );
        }).collect(Collectors.toList());
    }
}

