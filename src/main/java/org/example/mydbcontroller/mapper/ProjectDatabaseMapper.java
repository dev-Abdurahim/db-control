package org.example.mydbcontroller.mapper;

import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.dto.projectdatabase.ProjectDatabaseCreateDto;
import org.example.mydbcontroller.dto.projectdatabase.ProjectDatabaseDto;
import org.example.mydbcontroller.dto.projectdatabase.ProjectDatabaseUpdateDto;
import org.example.mydbcontroller.dto.projectdatabaseuser.ProjectDatabaseUserDto;
import org.example.mydbcontroller.mapper.base.BaseMapper;
import org.example.mydbcontroller.model.entity.ProjectAgent;
import org.example.mydbcontroller.model.entity.ProjectDatabase;
import org.example.mydbcontroller.model.entity.ProjectDatabaseUser;
import org.example.mydbcontroller.validator.ProjectAgentBaseValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectDatabaseMapper
        implements BaseMapper<ProjectDatabaseDto, ProjectDatabaseCreateDto, ProjectDatabaseUpdateDto,ProjectDatabase> {

    private final ProjectDatabaseUserMapper projectDatabaseUserMapper;
    private final ProjectAgentBaseValidator projectAgentValidator;

    @Override
    public ProjectDatabaseDto toDto(ProjectDatabase entity) {
        List<ProjectDatabaseUser> members = entity.getMembers();
        ProjectAgent agent = entity.getAgent();

        List<ProjectDatabaseUserDto> memberList = members.stream()
                .map(projectDatabaseUserMapper::toDto)
                .collect(Collectors.toList());

        return ProjectDatabaseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .agentId(agent.getId())
                .members(memberList)
                .build();
    }

    @Override
    public ProjectDatabase fromCreateDto(ProjectDatabaseCreateDto dto) {
        ProjectDatabase entity = new ProjectDatabase();
        ProjectAgent agent = projectAgentValidator.existsAndGet(dto.getAgentId());
        entity.setAgent(agent);
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public void fromUpdateDto(ProjectDatabaseUpdateDto dto, ProjectDatabase entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setAgent(projectAgentValidator.existsAndGet(dto.getAgentId()));

    }
}
