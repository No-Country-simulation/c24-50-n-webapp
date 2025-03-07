package com.nobank.services;

import com.nobank.domain.model.User;

import java.util.List;

public interface UserService {
    List<User> listarUsuarios();

    User buscarPorId(Long id);

    boolean existsByUsername(String username);

    User guardarUsuario(User user);

    void eliminarUsuario(Long id);

    User buscarPorEmail(String email);

    User buscarPorDni(String dni);

}
