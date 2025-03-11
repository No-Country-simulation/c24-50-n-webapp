package com.nobank.repository;

import com.nobank.domain.cuenta.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta,Long> {
    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);
}
