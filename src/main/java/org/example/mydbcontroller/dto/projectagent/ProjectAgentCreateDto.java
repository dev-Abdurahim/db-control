package org.example.mydbcontroller.dto.projectagent;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProjectAgentCreateDto {
    private String name;
    private String databaseUsername;
    private String databasePassword;
    private String databaseUrl;
    private String callbackUrl;
}
