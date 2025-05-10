package com.nobank.domain.transacción;


import java.math.BigDecimal;

public record DatosIngresarTranseferencia(
        String cuentaOrigen,
        String cuentaDestino,
        BigDecimal monto

) {
}
