package org.example.mydbcontroller.repository;

import org.example.mydbcontroller.model.entity.AuthPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthPermissionRepository extends JpaRepository<AuthPermission,String> {
}
