package org.example.mydbcontroller.repository;

import org.example.mydbcontroller.model.entity.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole,String> {
}
