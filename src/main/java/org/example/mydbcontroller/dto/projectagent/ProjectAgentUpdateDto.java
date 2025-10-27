package org.example.mydbcontroller.dto.projectagent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectAgentUpdateDto {

    private String name;
    private String databaseUsername;
    private String databasePassword;
    private String databaseUrl;
    private String callbackUrl;
}
