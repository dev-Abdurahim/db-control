package org.example.mydbcontroller.mapper;

import org.example.mydbcontroller.dto.authpermission.AuthPermissionCreateDto;
import org.example.mydbcontroller.dto.authpermission.AuthPermissionDto;
import org.example.mydbcontroller.dto.authpermission.AuthPermissionUpdateDto;
import org.example.mydbcontroller.mapper.base.BaseMapper;
import org.example.mydbcontroller.model.entity.AuthPermission;
import org.springframework.stereotype.Component;


@Component
public class AuthPermissionMapper implements
        BaseMapper<AuthPermissionDto, AuthPermissionCreateDto, AuthPermissionUpdateDto, AuthPermission> {

    @Override
    public AuthPermissionDto toDto(AuthPermission entity) {
        return AuthPermissionDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .build();
    }

    @Override
    public AuthPermission fromCreateDto(AuthPermissionCreateDto dto) {
        AuthPermission authPermission = new AuthPermission();
        authPermission.setName(dto.getName());
        authPermission.setCode(dto.getCode());
        return authPermission;
    }

    @Override
    public void fromUpdateDto(AuthPermissionUpdateDto dto, AuthPermission entity) {
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
    }
}
