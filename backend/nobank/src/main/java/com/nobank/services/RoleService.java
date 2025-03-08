package com.nobank.services;

import java.util.List;
import java.util.Optional;

import com.nobank.entities.Role;

public interface RoleService {
    List<Role> listarRoles();
    Optional<Role> buscarRolePorId(Long id);
    Role guardarRole(Role role);
    void eliminarRole(Long id);
    List<Role> buscarRolesPorIds(List<Long> ids);
    // ✅  NUEVO MÉTODO: agregarPermisoARol
    //Role agregarPermisoARol(Long rolId, PermisoDTO permisoDto);
    Optional<Role> buscarRolePorNombre(String nombre);

}
