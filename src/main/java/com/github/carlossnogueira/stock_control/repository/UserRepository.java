package com.github.carlossnogueira.stock_control.repository;

import com.github.carlossnogueira.stock_control.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
