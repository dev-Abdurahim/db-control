package org.example.mydbcontroller.dto.projectdatabaseuser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDatabaseUserUpdateDto {
    private List<String> roleIds;
}
