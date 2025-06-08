package com.usuario.demoapi.repository;

import com.usuario.demoapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
