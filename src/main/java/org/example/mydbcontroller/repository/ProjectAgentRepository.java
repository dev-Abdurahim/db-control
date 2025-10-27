package org.example.mydbcontroller.repository;

import org.example.mydbcontroller.model.entity.ProjectAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProjectAgentRepository extends JpaRepository<ProjectAgent,String> {

}
