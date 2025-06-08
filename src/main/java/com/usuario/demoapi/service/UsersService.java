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
}
