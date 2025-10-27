package org.example.mydbcontroller.mapper;

import org.example.mydbcontroller.dto.projectagent.ProjectAgentCreateDto;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentDto;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentUpdateDto;
import org.example.mydbcontroller.model.entity.ProjectAgent;
import org.example.mydbcontroller.utils.Utils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProjectAgentMapperOld {
    public ProjectAgent fromDto(ProjectAgentCreateDto dto) {
        String userId = Utils.sessionUser().getUserId();
        ProjectAgent agent = new ProjectAgent();
        agent.setCallbackUrl(dto.getCallbackUrl());
        agent.setDatabaseUrl(dto.getDatabaseUrl());
        agent.setDatabaseUsername(dto.getDatabaseUsername());
        agent.setDatabasePassword(dto.getDatabasePassword());
        agent.setCreatedAt(LocalDateTime.now());
        agent.setUpdatedAt(LocalDateTime.now());
        agent.setCreatedBy(userId);
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
