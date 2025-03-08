package com.nobank.services;

import com.nobank.entities.User;
import com.nobank.models.requests.UserRequest;
import com.nobank.models.responses.UserResponse;
import com.nobank.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<UserResponse> listarUsuarios() {
        return userRepository.findAll().stream()
                .map(this::entityToResponse)
                .toList();
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
    public UserResponse guardarUsuario(UserRequest request) {

        var userToPersist = User.builder()
                .username(request.getUsername())
                .dni(request.getDni())
                .password(request.getPassword())
                .email(request.getEmail())
                .status("active")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        // Guardar el usuario primero
        var userPersisted = userRepository.save(userToPersist);

        // Crear la cuenta para el usuario
        accountService.crearCuentaParaUsuario(userPersisted);

        return this.entityToResponse(userPersisted);
    }

    @Override
    public void eliminarUsuario(Long id) {
        var userFromToDelete = this.userRepository.findById(id).orElseThrow();
        userRepository.delete(userFromToDelete);
    }

    @Override
    public User buscarPorEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User buscarPorDni(String dni) {
        return userRepository.findByDni(dni).orElse(null);
    }

    private UserResponse entityToResponse(User entity) {
        var response = new UserResponse();
        BeanUtils.copyProperties(entity, response);
        entity.getAccounts().forEach(account -> response.setAccountNumber(account.getAccountNumber()));
        return response;
    }
}

