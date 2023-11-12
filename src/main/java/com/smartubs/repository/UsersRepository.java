package com.smartubs.repository;

import com.smartubs.model.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByLoginAndPassword(String login, String password);
}
