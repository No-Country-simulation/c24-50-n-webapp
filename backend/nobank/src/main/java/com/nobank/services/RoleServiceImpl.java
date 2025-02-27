package com.nobank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nobank.domain.model.Role;
import com.nobank.repositories.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> listarRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> buscarRolePorId(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role guardarRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void eliminarRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> buscarRolePorNombre(String nombre) {
        return roleRepository.findByName(nombre);
    }

}
