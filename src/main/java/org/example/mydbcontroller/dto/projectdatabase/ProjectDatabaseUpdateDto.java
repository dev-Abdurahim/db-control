package org.example.mydbcontroller.dto.projectdatabase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDatabaseUpdateDto {
    private String name;
    private String description;
    private String agentId;
}
