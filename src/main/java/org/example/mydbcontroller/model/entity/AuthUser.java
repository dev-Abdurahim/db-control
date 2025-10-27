package org.example.mydbcontroller.model.entity;


// AuthUser bu hub ga login qiladiga user

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.mydbcontroller.model.base.BaseEntity;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser extends BaseEntity {
    private String name;
    private String username;
    private String password;
    private String dbUsername;
    private String dbPassword;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private AuthRole role;

}
