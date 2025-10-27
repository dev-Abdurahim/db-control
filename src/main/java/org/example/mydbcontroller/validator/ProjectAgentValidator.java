package org.example.mydbcontroller.validator;

import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentCreateDto;
import org.example.mydbcontroller.model.entity.ProjectAgent;
import org.example.mydbcontroller.repository.ProjectAgentRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectAgentValidator {

    private final ProjectAgentRepository repository;

    public void validateOnCreate(ProjectAgentCreateDto dto){

    }
    public ProjectAgent existAndGet(String id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Project agent with id " + id + " not found")
        );
    }

}
