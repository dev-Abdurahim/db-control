package org.example.mydbcontroller.repository;

import org.example.mydbcontroller.model.entity.ProjectDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDatabaseRepository extends JpaRepository<ProjectDatabase,String> {
}
