package org.example.mydbcontroller.mapper;

import org.example.mydbcontroller.model.dto.ProjectAgentCreateDto;
import org.example.mydbcontroller.model.dto.ProjectAgentDto;
import org.example.mydbcontroller.model.dto.ProjectAgentUpdateDto;
import org.example.mydbcontroller.model.entity.ProjectAgent;
import org.springframework.stereotype.Component;

@Component
public class ProjectAgentMapper {
    public ProjectAgent fromDto(ProjectAgentCreateDto dto){
        ProjectAgent agent = new ProjectAgent();
        agent.setCallbackUrl(dto.getCallbackUrl());
        agent.setDatabaseUrl(dto.getDatabaseUrl());
        agent.setDatabaseUsername(dto.getDatabaseUsername());
        agent.setDatabasePassword(dto.getDatabasePassword());
        return agent;
    }
    public void fromDto(ProjectAgentUpdateDto dto, ProjectAgent agent) {
        agent.setCallbackUrl(dto.getCallbackUrl());
        agent.setDatabaseUrl(dto.getDatabaseUrl());
        agent.setDatabaseUsername(dto.getDatabaseUsername());
        agent.setDatabasePassword(dto.getDatabasePassword());
    }
    public ProjectAgentDto toDto(ProjectAgent save) {
        return ProjectAgentDto.builder()
                .id(save.getId())
                .callbackUrl(save.getCallbackUrl())
                .databaseUrl(save.getDatabaseUrl())
                .databaseUsername(save.getDatabaseUsername())
                .databasePassword(save.getDatabasePassword())
                .build();

    }
}
