package com.nobank.domain.usuario;

import com.nobank.domain.rolTipo.RolTipo;

public record DatosRegistroUsuario(
        String nombre,
        String dni,
        String correo,
        String contraseña
) {
}
