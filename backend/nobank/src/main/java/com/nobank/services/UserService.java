package com.nobank.services;

import com.nobank.entities.User;
import com.nobank.models.requests.UserRequest;
import com.nobank.models.responses.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> listarUsuarios();

    User buscarPorId(Long id);

    boolean existsByUsername(String username);

    UserResponse guardarUsuario(UserRequest request);

    void eliminarUsuario(Long id);

    User buscarPorEmail(String email);

    User buscarPorDni(String dni);

}
