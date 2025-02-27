package com.nobank.services;

import java.util.List;

import com.nobank.domain.model.User;

public interface UserService {
    List<User> listarUsuarios();

    User buscarPorId(Long id);

    boolean existsByUsername(String username);

    void guardarUsuario(User user);

    void eliminarUsuario(Long id);

    User buscarPorEmail(String email);
    
    User buscarPorDni(String dni);

}
