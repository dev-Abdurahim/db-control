package org.example.mydbcontroller.mapper;

import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.dto.IdNameDto;
import org.example.mydbcontroller.dto.projectdatabaseuser.ProjectDatabaseUserCreateDto;
import org.example.mydbcontroller.dto.projectdatabaseuser.ProjectDatabaseUserDto;
import org.example.mydbcontroller.dto.projectdatabaseuser.ProjectDatabaseUserUpdateDto;
import org.example.mydbcontroller.mapper.base.BaseMapper;
import org.example.mydbcontroller.model.entity.AuthUser;
import org.example.mydbcontroller.model.entity.DatabaseRole;
import org.example.mydbcontroller.model.entity.ProjectDatabase;
import org.example.mydbcontroller.model.entity.ProjectDatabaseUser;
import org.example.mydbcontroller.repository.DatabaseRoleRepository;
import org.example.mydbcontroller.validator.AuthUserValidator;
import org.example.mydbcontroller.validator.ProjectDatabaseValidator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectDatabaseUserMapper implements
        BaseMapper<ProjectDatabaseUserDto,
                ProjectDatabaseUserCreateDto,
                ProjectDatabaseUserUpdateDto,
                ProjectDatabaseUser> {
    private final ProjectDatabaseValidator projectDatabaseValidator;
    private final AuthUserValidator authUserValidator;
    private final DatabaseRoleRepository databaseRoleRepository;


    @Override
    public ProjectDatabaseUserDto toDto(ProjectDatabaseUser entity) {
        List<IdNameDto> dbRoles = entity.getRoles()
                .stream()
                .map(dr -> IdNameDto.builder().id(dr.getId()).name(dr.getName()).build())
                .toList();
        return ProjectDatabaseUserDto.builder()
                .id(entity.getId())
                .roles(dbRoles)
                .name(entity.getAuthUser().getName())
                .build();
    }

    @Override
    public ProjectDatabaseUser fromCreateDto(ProjectDatabaseUserCreateDto dto) {
        ProjectDatabase projectDatabase = projectDatabaseValidator.existsAndGet(dto.getDatabaseId());
        AuthUser authUser = authUserValidator.existsAndGet(dto.getAuthUserId());
        List<DatabaseRole> databaseRoles = databaseRoleRepository.findAllByIdIn(dto.getRoleIds());

        ProjectDatabaseUser entity = new ProjectDatabaseUser();
        entity.setDatabase(projectDatabase);
        entity.setAuthUser(authUser);
        entity.setRoles(databaseRoles);
        return entity;
    }

    @Override
    public void fromUpdateDto(ProjectDatabaseUserUpdateDto dto, ProjectDatabaseUser entity) {
        List<DatabaseRole> databaseRoles = databaseRoleRepository.findAllByIdIn(dto.getRoleIds());
        entity.setRoles(databaseRoles);
    }
}
