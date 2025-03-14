package com.nobank.service;

import com.nobank.domain.cuenta.Cuenta;
import java.text.NumberFormat;
import com.nobank.domain.transacción.Transaccion;
import com.nobank.domain.transacción.TransaccionDTO;
import com.nobank.repository.TransaccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class TransaccionService {

    @Autowired
    private NotificacionService notificacionService;

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


        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
        String montoFormateado = usdFormat.format(monto);


        String mensajeOrigen = "Se ha realizado una transferencia de " + montoFormateado + " a la cuenta " + cuentaDestino.getNumeroCuenta();
        String mensajeDestino = "Se ha recibido una transferencia de " + montoFormateado + " de la cuenta " + cuentaOrigen.getNumeroCuenta();


        notificacionService.crearNotificacion(cuentaOrigen.getUsuario().getId(), mensajeOrigen, "Transferencia");
        notificacionService.crearNotificacion(cuentaDestino.getUsuario().getId(), mensajeDestino, "Transferencia");

        Transaccion transacción = new Transaccion(cuentaOrigen, cuentaDestino, monto);
        return transaccionRepository.save(transacción);
    }

    public List<TransaccionDTO> obtenerMovimientosDeCuenta(Long cuentaId) {
        List<Transaccion> transacciones = transaccionRepository.findByCuentaOrigenIdOrCuentaDestinoIdOrderByFechaDesc(cuentaId, cuentaId)
                .orElseThrow(() -> new RuntimeException("No se encontraron transacciones"));

        return transacciones.stream().map(transaccion -> {
            boolean esIngreso = transaccion.getCuentaDestino().getId().equals(cuentaId);
            return new TransaccionDTO(
                    transaccion.getId(),
                    esIngreso ? transaccion.getCuentaOrigen().getUsuario().getPerfil().getNombre() : transaccion.getCuentaDestino().getUsuario().getPerfil().getNombre(),
                    "Transferencia",
                    esIngreso ? transaccion.getMonto() : transaccion.getMonto().negate(),
                    transaccion.getCuentaOrigen().getId(),
                    transaccion.getCuentaDestino().getId(),
                    transaccion.getEstado(),
                    transaccion.getFecha()
            );
        }).collect(Collectors.toList());
    }
}

