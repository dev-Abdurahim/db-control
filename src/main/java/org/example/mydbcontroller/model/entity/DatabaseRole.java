package org.example.mydbcontroller.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.mydbcontroller.model.base.IdEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseRole extends IdEntity {
    private String name;
    private String code;
    private String description;
}
