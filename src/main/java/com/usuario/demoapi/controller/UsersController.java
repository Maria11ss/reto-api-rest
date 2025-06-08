package com.usuario.demoapi.controller;

import com.usuario.demoapi.model.Users;
import com.usuario.demoapi.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Users API", description = "Manejo de registros de usuarios")
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    @Operation(summary = "Crear un nuevo usuario")
    public ResponseEntity<Users> create(@RequestBody Users users){
        return ResponseEntity.ok(usersService.save(users));
    }

    @GetMapping
    @Operation(summary = "Obtener todos los usuarios registrados")
    public ResponseEntity<List<Users>> getAll(){
        return ResponseEntity.ok(usersService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener registro del usuario")
    public ResponseEntity<Optional<Users>> getUser(@PathVariable Long id){
        return ResponseEntity.ok(usersService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un usuario registrado")
    public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users users){
        return ResponseEntity.ok(usersService.update(users));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario registrado")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
