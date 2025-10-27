package org.example.mydbcontroller.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.mydbcontroller.model.base.IdEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// AuthPermission — bu ruxsat (permission), ya’ni tizimda bajariladigan amallarni bildiradi.
public class AuthPermission extends IdEntity{
    private String name;
    private String code;
}
