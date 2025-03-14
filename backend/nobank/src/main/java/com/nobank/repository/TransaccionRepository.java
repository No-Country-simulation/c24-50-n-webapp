package com.nobank.repository;

import com.nobank.domain.transacción.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransaccionRepository extends JpaRepository<Transaccion,Long> {
    Optional<List<Transaccion>> findByCuentaOrigenIdOrCuentaDestinoIdOrderByFechaDesc(Long cuentaOrigenId, Long cuentaDestinoId);
}
