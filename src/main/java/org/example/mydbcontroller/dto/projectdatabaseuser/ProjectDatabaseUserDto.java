package org.example.mydbcontroller.dto.projectdatabaseuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mydbcontroller.dto.IdNameDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDatabaseUserDto {
    private String id;
    private String name;
    private List<IdNameDto> roles;
}
