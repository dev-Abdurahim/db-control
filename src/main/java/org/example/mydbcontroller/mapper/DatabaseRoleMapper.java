package org.example.mydbcontroller.mapper;

import org.example.mydbcontroller.dto.databserole.DatabaseRoleCreateDto;
import org.example.mydbcontroller.dto.databserole.DatabaseRoleDto;
import org.example.mydbcontroller.dto.databserole.DatabaseRoleUpdateDto;
import org.example.mydbcontroller.mapper.base.BaseMapper;
import org.example.mydbcontroller.model.entity.DatabaseRole;
import org.springframework.stereotype.Component;

@Component
public class DatabaseRoleMapper implements
        BaseMapper<DatabaseRoleDto, DatabaseRoleCreateDto, DatabaseRoleUpdateDto,DatabaseRole> {

    @Override
    public DatabaseRoleDto toDto(DatabaseRole entity) {
        return DatabaseRoleDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public DatabaseRole fromCreateDto(DatabaseRoleCreateDto dto) {
        DatabaseRole entity = new DatabaseRole();
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public void fromUpdateDto(DatabaseRoleUpdateDto dto, DatabaseRole entity) {
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
    }
}
