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

//@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen - Aqui va la URL de React o Frontend
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

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
            // Refrescar el usuario desde la base de datos para asegurarse de que se obtenga el valor actualizado de admin
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

        // Verificar si el email ya existe (sin cambios)
        if (userService.buscarPorEmail(user.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El email ya está registrado."));
        }

        // Verificar si el DNI ya existe (sin cambios)
        if (userService.buscarPorDni(user.getDni()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El DNI ya está registrado."));
        }

        // Verificar si el username ya existe (sin cambios)
        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El nombre de usuario ya está en uso."));
        }

        // Guardar usuario
        userService.guardarUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


}
