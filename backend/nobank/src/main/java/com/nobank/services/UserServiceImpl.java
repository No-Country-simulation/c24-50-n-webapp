package com.nobank.services;

import com.nobank.domain.model.Account;
import com.nobank.domain.model.User;
import com.nobank.repositories.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public User buscarPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Transactional
    @Override
    public User guardarUsuario(User user) {
        // Guardar el usuario primero
        userRepository.save(user);

        // Crear la cuenta para el usuario
        Account nuevaCuenta = accountService.crearCuentaParaUsuario(user);

        // Asociar la cuenta al usuario
        user.setAccounts(Collections.singletonList(nuevaCuenta)); // Asignar la cuenta al usuario

        // Guardar el usuario con la cuenta asociada
        return userRepository.save(user); // Guardamos el usuario con la cuenta ahora asociada
    }

    @Override
    public void eliminarUsuario(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User buscarPorEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User buscarPorDni(String dni) {
        return userRepository.findByDni(dni).orElse(null);
    }
}

