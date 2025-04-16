package com.example.cinema.controller;

import com.example.cinema.entity.Role;
import com.example.cinema.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    // Получить все роли
    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    // Получить роль по ID
    @GetMapping("/{id}")
    public Optional<Role> getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    // Создание новой роли
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role createRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    // Обновить существующую роль
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    // Удалить роль
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}