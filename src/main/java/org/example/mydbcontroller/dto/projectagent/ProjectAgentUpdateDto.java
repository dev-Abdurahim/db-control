package org.example.mydbcontroller.dto.projectagent;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAgentUpdateDto {
    private String name;
    private String databaseUsername;
    private String databasePassword;
    private String databaseUrl;
    private String callbackUrl;
}
