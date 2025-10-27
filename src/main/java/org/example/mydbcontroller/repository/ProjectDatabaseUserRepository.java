package org.example.mydbcontroller.repository;

import org.example.mydbcontroller.model.entity.ProjectDatabaseUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectDatabaseUserRepository extends JpaRepository<ProjectDatabaseUser,String> {
}
