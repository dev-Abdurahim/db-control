package org.example.mydbcontroller.repository;

import org.example.mydbcontroller.model.entity.DatabaseRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseRoleRepository extends JpaRepository<DatabaseRole,String> {
    List<DatabaseRole> findAllByIdIn(List<String> ids);
}
