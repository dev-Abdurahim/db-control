package org.example.mydbcontroller.dto.databserole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatabaseRoleDto {
    private String id;
    private String name;
    private String code;
    private String description;
}
