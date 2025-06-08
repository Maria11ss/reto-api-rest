package com.usuario.demoapi.service;

import com.usuario.demoapi.model.Users;
import com.usuario.demoapi.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private static final Logger log = LoggerFactory.getLogger(UsersService.class);

    public Users save(Users users) {
        log.info("Guardando usuario: {}", users);
        return repository.save(users);
    }

    public List<Users> findAll() {
        log.info("Obteninedo todos los usuarios");
        return repository.findAll();
    }

    public Users update(Users users) {
        Users user = repository.findById(users.getId()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (users.getName() != null) {
            user.setName(users.getName());
        }
        if (users.getEmail() != null) {
            user.setEmail(users.getEmail());
        }
        log.info("Actualizando usuario: {}", users);
        return repository.save(users);
    }

    public void delete(Long id) {
        Users user = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (user != null) {
            log.info("Eliminando usuario con id: {}", id);
            repository.delete(user);
        }
    }
}
