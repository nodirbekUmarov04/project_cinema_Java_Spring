package com.example.cinema.service;


import com.example.cinema.entity.Role;
import com.example.cinema.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role updateRole(Long id, Role role) {
        return roleRepository.findById(id)
                .map(existingRole -> {
                    existingRole.setName(role.getName());
                    existingRole.setUsers(role.getUsers()); // Если нужно обновлять пользователей в роли
                    return roleRepository.save(existingRole);
                })
                .orElse(null);
    }


    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}