package com.nobank.services;

import com.nobank.domain.model.User;
import com.nobank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public void guardarUsuario(User user) {
        userRepository.save(user);
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
