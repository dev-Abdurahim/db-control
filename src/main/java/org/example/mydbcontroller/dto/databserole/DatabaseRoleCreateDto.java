package org.example.mydbcontroller.dto.databserole;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseRoleCreateDto {
    private String name;
    private String code;
    private String description;
}
