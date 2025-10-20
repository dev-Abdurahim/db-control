package org.example.mydbcontroller.repository;

import org.example.mydbcontroller.model.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser,String> {
    Optional<AuthUser> findByUsernameAndDeletedIsFalse(String username);
}
