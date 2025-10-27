package org.example.mydbcontroller.dto.authuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mydbcontroller.dto.IdNameDto;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUserDto {
    private String id;
    private String username;
    private String email;
    private String phone;
    private IdNameDto role;
}
