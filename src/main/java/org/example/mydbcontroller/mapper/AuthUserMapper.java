package org.example.mydbcontroller.mapper;

import org.example.mydbcontroller.dto.IdNameDto;
import org.example.mydbcontroller.dto.authuser.AuthUserCreateDto;
import org.example.mydbcontroller.dto.authuser.AuthUserDto;
import org.example.mydbcontroller.dto.authuser.AuthUserUpdateDto;
import org.example.mydbcontroller.mapper.base.BaseMapper;
import org.example.mydbcontroller.model.entity.AuthRole;
import org.example.mydbcontroller.model.entity.AuthUser;
import org.example.mydbcontroller.validator.AuthRoleValidator;
import org.springframework.stereotype.Component;

@Component
public class AuthUserMapper implements
        BaseMapper<AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto, AuthUser> {

    private final AuthRoleValidator authRoleValidator;

    public AuthUserMapper(AuthRoleValidator authRoleValidator) {
        this.authRoleValidator = authRoleValidator;
    }


    @Override
    public AuthUserDto toDto(AuthUser entity) {
        AuthRole role = entity.getRole();
        IdNameDto roleDto = (role == null) ? null : IdNameDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
        return AuthUserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .role(roleDto)
                .build();
    }

    @Override
    public AuthUser fromCreateDto(AuthUserCreateDto dto) {
      AuthRole role =  authRoleValidator.existsAndGet(dto.getRoleId());
      AuthUser entity = new AuthUser();
        entity.setUsername(dto.getUsername());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setRole(role);
        return entity;

    }

    @Override
    public void fromUpdateDto(AuthUserUpdateDto dto, AuthUser entity) {
        AuthRole role = authRoleValidator.existsAndGet(dto.getRoleId());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setDbUsername(dto.getDbUsername());
        entity.setDbPassword(dto.getDbPassword());
        entity.setRole(role);
    }
}
