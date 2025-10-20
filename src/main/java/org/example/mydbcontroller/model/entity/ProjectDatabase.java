package org.example.mydbcontroller.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.mydbcontroller.model.base.BaseEntity;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProjectDatabase extends BaseEntity {
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name = "agent_id")
    private ProjectAgent agent;

    @OneToMany(mappedBy = "database")
    private List<ProjectDatabaseUser> members;
}
