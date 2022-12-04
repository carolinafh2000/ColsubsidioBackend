package com.prueba.demo.Model.Repository;

import com.prueba.demo.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findOneByEmail(String email);
}
