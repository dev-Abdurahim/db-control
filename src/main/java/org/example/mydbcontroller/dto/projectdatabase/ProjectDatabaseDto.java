package org.example.mydbcontroller.dto.projectdatabase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mydbcontroller.dto.projectdatabaseuser.ProjectDatabaseUserCreateDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDatabaseDto {
    private String id;
    private String name;
    private String description;
    private String agentId;
    private List<ProjectDatabaseUserCreateDto> members;
}
