package org.example.mydbcontroller.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.mydbcontroller.model.base.BaseEntity;
import org.example.mydbcontroller.model.base.IdEntity;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AuthRole extends IdEntity {
    private String name;
    private String code;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "auth_role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    List<AuthPermission> permissions;
}