package org.example.mydbcontroller.mapper;

import lombok.RequiredArgsConstructor;
import org.example.mydbcontroller.dto.authpermission.AuthPermissionDto;
import org.example.mydbcontroller.dto.authrole.AuthRoleCreateDto;
import org.example.mydbcontroller.dto.authrole.AuthRoleDto;
import org.example.mydbcontroller.dto.authrole.AuthRoleUpdateDto;
import org.example.mydbcontroller.mapper.base.BaseMapper;
import org.example.mydbcontroller.model.entity.AuthPermission;
import org.example.mydbcontroller.model.entity.AuthRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthRoleMapper implements
        BaseMapper<AuthRoleDto, AuthRoleCreateDto, AuthRoleUpdateDto, AuthRole> {

    private final AuthPermissionMapper authPermissionMapper;
    @Override
    public AuthRoleDto toDto(AuthRole entity) {
        List<AuthPermission> permissions = entity.getPermissions();
        List<AuthPermissionDto> permissionDtoList = permissions.stream()
                .map(authPermissionMapper::toDto)
                .toList();

        return AuthRoleDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .permissionIds(permissionDtoList)
                .build();
    }

    @Override
    public AuthRole fromCreateDto(AuthRoleCreateDto dto) {
//        AuthRole authRole = new AuthRole();
//        authRole.
        return null;
    }

    @Override
    public void fromUpdateDto(AuthRoleUpdateDto dto, AuthRole entity) {

    }
}
