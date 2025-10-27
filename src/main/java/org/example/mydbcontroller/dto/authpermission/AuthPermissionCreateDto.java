package org.example.mydbcontroller.dto.authpermission;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthPermissionCreateDto {
    private String name;
    private String code;
}
