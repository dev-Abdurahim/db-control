package org.example.mydbcontroller.dto.authuser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthUserUpdateDto {
    private String name;
    private String username;
    private String dbUsername;
    private String dbPassword;
    private String email;
    private String phone;
    private String roleId;
}
