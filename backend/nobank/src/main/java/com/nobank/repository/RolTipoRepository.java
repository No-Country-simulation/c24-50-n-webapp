package com.nobank.repository;

import com.nobank.domain.rolTipo.RolTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolTipoRepository extends JpaRepository<RolTipo, Long> {
    Optional<RolTipo> findByNombre(String nombre);
}
