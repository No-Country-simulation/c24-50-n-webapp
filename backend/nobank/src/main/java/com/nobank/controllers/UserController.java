package com.nobank.controllers;

import com.nobank.domain.model.User;
import com.nobank.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobank.domain.model.Account;
import com.nobank.domain.model.Role;
import com.nobank.domain.model.User;
import com.nobank.services.AccountService;
import com.nobank.services.RoleService;
import com.nobank.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;


//@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen - Aqui va la URL de React o Frontend
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Operation(summary = "Listar todos los usuarios")
    @GetMapping
    public List<User> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @Operation(summary = "Buscar usuario por ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable Long id) {
        User user = userService.buscarPorId(id);
        if (user != null) {
            // Refrescar el usuario desde la base de datos para asegurarse de que se obtenga
            // el valor actualizado de admin
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Registrar nuevo usuario CLIENTE
    @Operation(summary = "Registrar nuevo usuario CLIENTE")
    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody User user, BindingResult result) {

        // Validar errores de entrada
        if (result.hasErrors()) {
            Map<String, Object> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), err.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(result.getAllErrors());
        }

        // Verificar si el email ya existe
        if (userService.buscarPorEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El email ya está registrado."));
        }

        // Verificar si el DNI ya existe
        if (userService.buscarPorDni(user.getDni()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El DNI ya está registrado."));
        }

        // Verificar si el username ya existe
        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El nombre de usuario ya está en uso."));
        }

        // Guardar usuario
        userService.guardarUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

        // Guardar usuario y crear cuenta automáticamente
        User nuevoUsuario = userService.guardarUsuario(user);
        Account nuevaCuenta = accountService.crearCuentaParaUsuario(nuevoUsuario);

        // Asignar cuenta al usuario
        nuevoUsuario.getAccounts().add(nuevaCuenta);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @Operation(summary = "Asignar roles a un usuario")
    @PutMapping("/{userId}/roles")
    public ResponseEntity<?> asignarRoles(@PathVariable Long userId, @RequestBody List<Long> roleIds) {
        User usuario = userService.buscarPorId(userId);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        List<Role> roles = roleService.buscarRolesPorIds(roleIds);

        if (roles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ningún rol válido encontrado");
        }

        usuario.setRoles(roles);
        userService.guardarUsuario(usuario);

        return ResponseEntity.ok(usuario);
    }

}
