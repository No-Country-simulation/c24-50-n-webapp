package com.nobank.domain.transacción;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransaccionDTO(
        Long id,
        String name,
        String type,
        BigDecimal amount,
        Long cuentaOrigenId,
        Long cuentaDestinoId,
        String estado,
        LocalDateTime fecha
) {}