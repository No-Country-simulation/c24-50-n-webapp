package com.nobank.domain.notificacion;

import java.time.LocalDateTime;

public record NotificacionDTO(
        Long id,
        LocalDateTime fecha,
        String mensaje,
        String type,
        Long id_usuario
) {}