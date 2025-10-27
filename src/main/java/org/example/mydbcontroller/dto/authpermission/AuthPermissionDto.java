package org.example.mydbcontroller.dto.authpermission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthPermissionDto {
    private String id;
    private String name;
    private String code;
}
