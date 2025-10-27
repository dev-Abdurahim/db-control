package org.example.mydbcontroller.dto.projectagent;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAgentCreateDto {
    private String name;
    private String username;
    private String password;
    private String databaseUrl;
    private String callbackUrl;
}
