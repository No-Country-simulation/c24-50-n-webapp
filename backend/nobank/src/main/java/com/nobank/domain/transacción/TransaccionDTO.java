package com.nobank.domain.transacción;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransaccionDTO(
        Long id,
        BigDecimal monto,
        String tipoMovimiento,
        Long cuentaOrigenId,
        Long cuentaDestinoId,
        String estado,
        LocalDateTime fecha
) {}