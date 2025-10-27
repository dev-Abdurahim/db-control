package org.example.mydbcontroller.dto.projectagent;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProjectAgentDto {
    private String id;
    private String name;
    private String databaseUsername;
    private String databasePassword;
    private String databaseUrl;
    private String callbackUrl;
}
