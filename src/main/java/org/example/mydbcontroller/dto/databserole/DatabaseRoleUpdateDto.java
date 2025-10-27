package org.example.mydbcontroller.dto.databserole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatabaseRoleUpdateDto {
    private String name;
    private String code;
    private String description;
}
