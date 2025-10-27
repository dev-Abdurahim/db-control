package org.example.mydbcontroller.model.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.example.mydbcontroller.model.base.BaseEntity;
import org.springframework.context.annotation.Scope;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectAgent extends BaseEntity {
    private String name;
    private String databaseUsername; // bu osha projectdagi databaseni superUserName hamma xuquqlari bor
    private String databasePassword;
    private String databaseUrl;
    private String callbackUrl;
}
