package com.nobank.controllers;

import com.nobank.entities.User;
import com.nobank.models.requests.UserRequest;
import com.nobank.models.responses.UserResponse;
import com.nobank.services.AccountService;
import com.nobank.services.RoleService;
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

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Operation(summary = "Listar todos los usuarios")
    @GetMapping
    public List<UserResponse> listarUsuarios() {
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
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody UserRequest request, BindingResult result) {

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
        if (userService.buscarPorEmail(request.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El email ya está registrado."));
        }

        // Verificar si el DNI ya existe
        if (userService.buscarPorDni(request.getDni()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El DNI ya está registrado."));
        }

        // Verificar si el username ya existe
        if (userService.existsByUsername(request.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "El nombre de usuario ya está en uso."));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.guardarUsuario(request));
    }

//    @Operation(summary = "Asignar roles a un usuario")
//    @PutMapping("/{userId}/roles")
//    public ResponseEntity<?> asignarRoles(@PathVariable Long userId, @RequestBody List<Long> roleIds) {
//        User usuario = userService.buscarPorId(userId);
//
//        if (usuario == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
//        }
//
//        List<Role> roles = roleService.buscarRolesPorIds(roleIds);
//
//        if (roles.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ningún rol válido encontrado");
//        }
//
//        usuario.setRoles(roles);
//        userService.guardarUsuario(usuario);
//
//        return ResponseEntity.ok(usuario);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
