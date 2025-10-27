package org.example.mydbcontroller.mapper;

import org.example.mydbcontroller.dto.projectagent.ProjectAgentCreateDto;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentDto;
import org.example.mydbcontroller.dto.projectagent.ProjectAgentUpdateDto;
import org.example.mydbcontroller.mapper.base.BaseMapper;
import org.example.mydbcontroller.model.entity.ProjectAgent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public class ProjectAgentMapper
        implements BaseMapper<ProjectAgentDto,ProjectAgentCreateDto, ProjectAgentUpdateDto,ProjectAgent> {

    @Override
    public ProjectAgentDto toDto(ProjectAgent entity) {
        return ProjectAgentDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .callbackUrl(entity.getCallbackUrl())
                .databaseUrl(entity.getDatabaseUrl())
                .databaseUsername(entity.getDatabaseUsername())
                .build();
    }

    @Override
    public ProjectAgent fromCreateDto(ProjectAgentCreateDto dto) {
        return new ProjectAgent(dto.getName(), dto.getUsername(), dto.getPassword(), dto.getDatabaseUrl(), dto.getCallbackUrl());
    }

    @Override
    public void fromUpdateDto(ProjectAgentUpdateDto dto,  @MappingTarget ProjectAgent entity) {
        entity.setDatabasePassword(dto.getDatabasePassword());
        entity.setDatabaseUrl(dto.getDatabaseUrl());
        entity.setName(dto.getName());
        entity.setCallbackUrl(dto.getCallbackUrl());
        entity.setDatabaseUsername(dto.getDatabaseUsername());
    }
}

