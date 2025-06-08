package com.usuario.demoapi.controller;

import com.usuario.demoapi.model.Users;
import com.usuario.demoapi.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
