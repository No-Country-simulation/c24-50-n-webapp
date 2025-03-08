package com.nobank.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobank.domain.model.Role;
import com.nobank.services.RoleService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

//@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen - Aqui va la URL de React o Frontend
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // 🔹 Listar todos los roles
    @Operation(summary = "Listar todos los roles")
    @GetMapping
    public ResponseEntity<List<Role>> listarRoles() {
        List<Role> roles = roleService.listarRoles();

        // Cargar los usuarios de cada rol manualmente si es necesario
        roles.forEach(role -> role.getUsuarios().size());
        return ResponseEntity.ok(roles);
    }

    // 🔹 Crear un nuevo rol
    @Operation(summary = "Crear un nuevo rol")
    @PostMapping
    public ResponseEntity<?> crearRol(@Valid @RequestBody Role role, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        roleService.guardarRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

}
