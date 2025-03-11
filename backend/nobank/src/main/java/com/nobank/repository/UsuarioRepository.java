package com.nobank.repository;

import com.nobank.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository <Usuario,Long> {
    UserDetails findByDni(String dni);
}
