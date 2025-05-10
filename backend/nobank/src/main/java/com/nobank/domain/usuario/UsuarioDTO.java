package com.nobank.domain.usuario;

import java.math.BigDecimal;

public record UsuarioDTO(
        String nombre,
        String numeroCuenta,
        Long id_Cuenta,
        BigDecimal balance
)
{
}
